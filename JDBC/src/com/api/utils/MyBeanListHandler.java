package com.api.utils;

import org.apache.commons.dbutils.ResultSetHandler;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class MyBeanListHandler <T> implements ResultSetHandler<List<T>> {
    private final Class<? extends T> type;

    public MyBeanListHandler(Class<? extends T> type) {
        this.type = type;
    }

    @Override
    public List<T> handle(ResultSet resultSet) throws SQLException {

        List<T> tList=new ArrayList<>();

        List<Map<String ,Object>> resultsList=new ArrayList<>();

        while (resultSet.next()){
            //实体
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
            tList.add(t);

            // 字段名：字段值
            Map<String ,Object> results=new HashMap<String ,Object>();
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i <=metaData.getColumnCount(); i++) {//列数
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
            }
            resultsList.add(results);
        }

        // 字段名：字段类型   实体类结构
        Map<String ,Class> properties=new HashMap<String ,Class>();
        Field[] fields = type.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            properties.put(fields[i].getName(),fields[i].getType());
            System.out.println(fields[i].getType()+"---"+fields[i].getName());
        }

        //为list中的实体赋值 返回结果集
        return setProperties(resultsList, properties, tList);
    }

    private List<T> setProperties(List<Map<String, Object>> resultsList, Map<String, Class> properties, List<T> tList) {
        for (int i = 0; i <tList.size() ; i++) {
            Iterator<String> iterator = properties.keySet().iterator();
            while (iterator.hasNext()) {
                String fieldName = iterator.next();
                Object value = resultsList.get(i).get(fieldName);
                setterCall(fieldName,properties.get(fieldName),value,tList.get(i));
            }
        }
        return tList;
    }

    public void  setterCall(String fieldName,Class propertyType,Object value,T t){
        //获取set方法名
        String methodName="set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
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
