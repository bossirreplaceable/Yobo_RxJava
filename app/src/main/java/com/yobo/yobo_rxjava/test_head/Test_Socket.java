package com.yobo.yobo_rxjava.test_head;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ZhangBoshi
 * on 2020-04-07
 */
public class Test_Socket {

    private static ServerSocket server;
    private static Socket client;

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                testServer();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                test();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    private static void testServer() throws IOException, InterruptedException {

        System.out.println("开始建立");
        server = new ServerSocket(5555);

        int count = 0;
        Thread.sleep(500);
        while (true) {

            Socket socket = server.accept();
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            String msg = "我是服务器，ID：" + count;
            System.out.println("服务器：" + msg);
            writer.println(msg);
            writer.close();
            count++;
        }
    }

    /**
     * 1、5000是端口号，用来识别服务器上特定应用程序的数字；
     * 2、TCP端口16位宽；
     * 3、一个IP地址可以有65536个不同的端口号；
     * 4、1～1023的TCP端口号是保留给已知的特定服务使用，你不该使用它们；
     */
    private static void test() throws IOException, InterruptedException {
        Thread.sleep(500);
        System.out.println("开始连接");
        client = new Socket("10.58.101.240", 5555);
        InputStreamReader reader = new InputStreamReader(client.getInputStream());
        BufferedReader buffer = new BufferedReader(reader);
        String msg = "1";
        while (true) {
            msg = buffer.readLine();
            System.out.println("客户端:" + msg);
            if (msg == null) {
                buffer.close();
                break;
            }
        }
    }

    private static void testClientSend() throws IOException, InterruptedException {
        Thread.sleep(500);
        System.out.println("开始连接");
        client = new Socket("10.58.101.240", 5555);
        OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
        PrintWriter print = new PrintWriter(writer);
        String msg = "客户端：我发送了一条消息";
        print.println(msg);

    }

}
