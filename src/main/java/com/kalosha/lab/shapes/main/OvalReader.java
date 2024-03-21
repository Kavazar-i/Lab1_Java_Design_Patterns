//package com.kalosha.lab.shapes.main;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import com.kalosha.lab.shapes.model.oval.Oval;
//import com.kalosha.lab.shapes.model.point.Point;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.List;
//
//public class OvalReader {
//    public static void main(String[] args) {
//        Gson gson = new Gson();
//
//        try (FileReader reader = new FileReader("ovals.json")) {
//            // Преобразование JSON-данных в список объектов OvalData
//            List<OvalData> ovalDataList = gson.fromJson(reader, new TypeToken<List<OvalData>>() {
//            }.getType());
//
//            // Создание овалов на основе данных из списка
//            for (OvalData ovalData : ovalDataList) {
//                Point pointA = new Point(ovalData.getX1(), ovalData.getY1());
//                Point pointB = new Point(ovalData.getX2(), ovalData.getY2());
//                Oval oval = new Oval(pointA, pointB);
//                System.out.println("Created oval: " + oval);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
