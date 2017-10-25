/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Servlet Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloWorld
*/

package com.example.IT.myapplication.backend;

import com.example.Result;
import com.google.gson.Gson;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest pRequest, HttpServletResponse pResponse) throws IOException {
        pResponse.setContentType("application/json");
        Result result = new Result();
        try {
            String e = pRequest.getParameter("input");
            String[] numbers = e.split("\\+");
            int firstNumber = Integer.parseInt(numbers[0]);
            int secondNumber = Integer.parseInt(numbers[1]);
            int sum = firstNumber * secondNumber;
            result.setSum(sum);
        } catch (Exception var9) {
            result.setError("101" + var9.toString());
        }

        (new Gson()).toJson(result, pResponse.getWriter());
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        resp.setContentType("text/plain");
        if (name == null || "".equals(name)) {
            resp.getWriter().println("Please enter a name");
        }

        resp.getWriter().println("Hello " + name);
    }
}