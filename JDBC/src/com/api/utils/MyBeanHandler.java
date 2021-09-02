package com.api.utils;

import org.apache.commons.dbutils.ResultSetHandler;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyBeanHandler <T> implements ResultSetHandler<T> {
    //待通过反射创建的类型
    private final Class<? extends T> type;
    //构造方法
    public MyBeanHandler(Class<? extends T> type) {
        this.type = type;
    }

    @Override
    public T handle(ResultSet resultSet)  {

        // 字段名：字段值
        Map<String ,Object> results=new HashMap<String ,Object>();
        // 字段名：字段类型   实体类结构
        Map<String ,Class> properties=new HashMap<String ,Class>();
        try{
            while (resultSet.next()) {//判断非空
                ResultSetMetaData metaData = resultSet.getMetaData();
                for (int i = 1; i <=metaData.getColumnCount(); i++) {
                    Object value=null;
                    switch (metaData.getColumnTypeName(i)) {
                        case "VARCHAR":
                            value=resultSet.getString(metaData.getColumnName(i));
                            break;
                        case "INT":
                            value=resultSet.getInt(metaData.getColumnName(i));
                            break;
                    }
                    results.put(metaData.getColumnName(i).toLowerCase(),value);
                    System.out.println(metaData.getColumnName(i).toLowerCase()+"---"+value);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        T t=null;
        try {
            //实体类结构
            t = type.getConstructor(null).newInstance(null);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Field[] fields = t.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            properties.put(fields[i].getName(),fields[i].getType());
            System.out.println(fields[i].getType()+"---"+fields[i].getName());
        }

        return setProperties(results, properties, t);
    }


    public T setProperties(Map<String ,Object> results,Map<String ,Class> properties,T t){
        //迭代器遍历map  利用反射机制 为t的属性赋值
        Iterator<String> iterator = properties.keySet().iterator();
        while (iterator.hasNext()) {
            String fieldName = iterator.next();
            Object value = results.get(fieldName);
            setterCall(fieldName,properties.get(fieldName),value,t);
        }
        return t;
    }

    //调用setter方法
    public void  setterCall(String fieldName,Class propertyType,Object value,T t){
        //获取set方法名
        String methodName="set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
        System.out.println(methodName);

        try {
            //根据方法名和字段类型  从实体类中获取set的methord
            Method method = t.getClass().getMethod(methodName, propertyType);
            //传入实体和参数值  调用method  为实体的相应字段赋值
            method.invoke(t,value);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
