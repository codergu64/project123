package com.ruoyi.web.test;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

import static org.opencv.core.CvType.CV_8UC1;
import static org.opencv.imgcodecs.Imgcodecs.*;

public class OpenCVTest {

    static String inFilepath = "C:\\Users\\Dell\\Desktop\\testD.jpg";

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        // 图像灰度 + 高斯模糊
//        grayScaleTest(inFilepath, "C:\\Users\\Dell\\Desktop\\A.jpg");
//        cvtColorTest(inFilepath, "C:\\Users\\Dell\\Desktop\\TestA1.jpg", 130.0);
        countHSV(inFilepath, "C:\\Users\\Dell\\Desktop\\TestN1.png");
    }

    public static void grayScaleTest(String inFilepath, String outFilepath){
        // 加载为灰度显示
//        Mat source1 = imread(inFilepath, CV_LOAD_IMAGE_GRAYSCALE);
        Mat source1 = imread(inFilepath);
//        Mat dest = new Mat(source.rows(), source.cols(), source.type());
        Mat dest1 = new Mat(source1.rows(), source1.cols(), source1.type());
        Mat dest2 = new Mat(source1.rows(), source1.cols(), source1.type());
        Mat dest3 = new Mat(source1.rows(), source1.cols(), source1.type());

        Imgproc.cvtColor(source1,dest1,Imgproc.COLOR_BGR2GRAY);
        Imgproc.cvtColor(source1,dest2,Imgproc.COLOR_BGR2GRAY);
        Imgproc.cvtColor(source1,dest3,Imgproc.COLOR_BGR2GRAY);


        // 高斯模糊
        Imgproc.GaussianBlur(dest1, dest1, new Size(15, 15), 0, 0);
        Imgproc.blur(dest2, dest2, new Size(15, 15));
        Imgproc.medianBlur(dest3, dest3, 15);
    /*
        // 二值化处理
        Imgproc.threshold(dest1, dest1, 170, 255, Imgproc.THRESH_BINARY_INV);
        // 腐蚀(cross：十字腐蚀)
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_CROSS, new Size(2 * 10 + 1, 2 * 10 + 1));
        Imgproc.erode(dest1, dest1, element);
        // 膨胀
        Imgproc.dilate(dest1, dest1, element);
        // 边缘检测
        List<MatOfPoint> matOfPoint = new ArrayList<>();
        Imgproc.findContours(dest1, matOfPoint, dest1, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE, new Point(0,0));*/
//        Imgproc.contourArea();
/*        for (int i = 0; i < matOfPoint.size(); i++) {
            Imgproc.drawContours(dest1, matOfPoint, i, new Scalar(255, 255, 255), 1);
        }*/
        //输出图片路径
//        imwrite(outFilepath, dest);
        imwrite("C:\\Users\\Dell\\Desktop\\Test1.jpg", dest1);
        imwrite("C:\\Users\\Dell\\Desktop\\Test2.jpg", dest2);
        imwrite("C:\\Users\\Dell\\Desktop\\Test3.jpg", dest3);
    }

    public static void cvtColorTest(String inFilepath, String outFilepath, Double thresh){
        // 加载为灰度显示
        Mat source = imread(inFilepath, CV_LOAD_IMAGE_GRAYSCALE);
        Mat dest = new Mat(source.rows(), source.cols(), source.type());
        Mat dest1 = new Mat(source.rows(), source.cols(), source.type());
        Imgproc.GaussianBlur(source, dest, new Size(2 * 10 + 1, 2 * 10 + 1), 0, 0);

        // 二值化处理
        Imgproc.threshold(source, dest1, thresh, 255, Imgproc.THRESH_BINARY_INV);
        // 边缘检测
//        Imgproc.Canny(source, dest1, 170, 170);
//        Imgproc.findContours(dest1, );
        imwrite(outFilepath, dest1);
    }

    public static void countHSV(String inFilepath, String outFilepath) {
        // 统计图像中的H、S、V三分量值
        Mat source = imread(inFilepath);
//        Mat dest = new Mat(source.rows(), source.cols(), source.type());
//        Imgproc.cvtColor(source, dest, Imgproc.COLOR_BGR2GRAY);
//        List<MatOfPoint> contours = new ArrayList<>();
//        Mat mat = new Mat();
//        Imgproc.findContours(dest, contours, mat, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE, new Point());
//        System.out.println(contours.size());
//        for (int i = 0; i < contours.size(); i++) {
//            Imgproc.drawContours(dest, contours, i, new Scalar(255), 1);
//        }
        Mat dst = source.clone();
        Imgproc.cvtColor(source, dst, Imgproc.COLOR_BGRA2GRAY);
        Imgproc.adaptiveThreshold(dst, dst, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C,
                Imgproc.THRESH_BINARY_INV, 3, 3);

        java.util.List<MatOfPoint> contours = new java.util.ArrayList<MatOfPoint>();
        Mat hierarchy = new Mat();
        Imgproc.findContours(dst, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE,
                new Point(0, 0));
//        System.out.println(contours.size());
//        double sum = 0;
//        for (int i = 0; i < contours.size(); i++) {
//            double area = Imgproc.contourArea(contours.get(i));
//            if (area < 20) {
//                contours.remove(contours.get(i));
//            }else {
//                sum += area;
//            }
//        }
//        System.out.println("sum:" + sum);
//        System.out.println(contours.size());
//
//        for (int i = 0; i < contours.size(); i++)
//        {
//
//            Imgproc.drawContours(dst, contours, i, new Scalar(255), 1);
//            System.out.println(i + "次");
//        }
        imwrite(outFilepath, dst);
    }


}
