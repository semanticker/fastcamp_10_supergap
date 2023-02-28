package org.example;

import org.example.calculator.Calculator;
import org.example.calculator.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWebApplictionServer {

    private final int port;

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplictionServer.class);

    public CustomWebApplictionServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomerWebApplicationServer] started {} port.", port);

            Socket clientSocket;
            logger.info("[CustomerWebApplicationServer] wating for client.");

            while ((clientSocket = serverSocket.accept()) != null) {

                logger.info("[CustomerWebApplicationServer] client connected!");

                /*
                 * Step - 사용자 요청을 메인 Thread가 처리하도록 한다.
                 */
                try (InputStream in = clientSocket.getInputStream();
                     OutputStream out = clientSocket.getOutputStream()){
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);

                    HttpRequest httpRequest = new HttpRequest(br);

                    // GET /calculate?operand1=
                    if (httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {
                        QueryStrings queryStrings = httpRequest.getQueryStrings();

                        /*
                        int operand1 = queryStrings.getValue("operand1");
                        String operator = queryStrings.getValue("operator");
                        int operand2 = queryStrings.getValue("operand2");

                        int result =   Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

                         */
                    }

                }

            }
        }
    }
}
