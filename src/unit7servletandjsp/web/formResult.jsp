<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Form Submission Result</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            flex-direction: column;
        }
        .result-container {
            background-color: #fff;
            padding: 20px 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: left;
            margin-bottom: 20px;
        }
        h2 {
            color: #333;
            margin-bottom: 20px;
            text-align: center;
        }
        p {
            color: #555;
            font-size: 16px;
            margin-bottom: 10px;
        }
        strong {
            color: #000;
        }
        .back-button {
            background-color: #6c757d;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
            display: inline-block;
            margin-top: 20px;
        }
        .back-button:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>
    <div class="result-container">
        <h2>Form Submission Details</h2>
        <p><strong>Name:</strong> <%= request.getAttribute("userName") %></p>
        <p><strong>Email:</strong> <%= request.getAttribute("userEmail") %></p>
        <p><strong>Message:</strong> <%= request.getAttribute("userMessage") %></p>
    </div>
    <a href="form.jsp" class="back-button">Go Back to Form</a>
</body>
</html>
