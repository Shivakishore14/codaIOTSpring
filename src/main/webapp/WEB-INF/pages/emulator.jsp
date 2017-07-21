<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Emulator</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="static/style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="col-md-4 col-md-offset-4">
                <center>
                    <div class="emulatorRoot form-group">
                        <h2>Device emulator</h2>
                        <input type="text" placeholder="cid" id="cid" class="form-control"><br>
                        <input type="text" placeholder="Sensor id" id="sid" class="form-control"><br>
                        <input type="text" placeholder="from value" id="from" class="form-control"> <br>
                        <input type="text" placeholder="to value" id="to" class="form-control"><br>
                        <input type="text" placeholder="secret" id="secret" class="form-control"><br>
                        <button onclick="btnClicked()" id="btn" class="btn full-width">start</button>
                    </div>
                </center>
            </div>
        </div>
    
    </body>
    <script>
        function sendVal(){
            var from = $("#from").val();
            var to = $("#to").val();
            var d = to - from;
            var val = Math.random() * d + from;
            var obj = {};
            obj.cid = $("#cid").val();
            obj.sid = $("#sid").val();
            obj.secret = $("#secret").val();
            obj.value = Math.round(val);
            obj.timestamp = (new Date()).toString();
            console.log(obj);
            $.post('<c:url value="/sensor/emulator/data" />',obj, function(result){
                console.log(result);
            });
        }
        var INTERVAL_ID = -1;
        var flag = true;
        function btnClicked(){
            
            if (flag){
                $("#btn").html("stop");
                INTERVAL_ID = setInterval(sendVal, 1000);
            }else{
                $("#btn").html("start");
                if(INTERVAL_ID != -1){
                    clearInterval(INTERVAL_ID);
                }
            }
            flag = !flag;
        }
    </script>
</html>