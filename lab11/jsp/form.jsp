<body>

        <b> AJAX Example (Header) </b>
        <form name="FHeader" action="#" method="POST">
                <input name="x" type="text" value="0" size="5" maxlength="5" />
                <input name="y" type="text" value="0" size="5" maxlength="5" />
                <input name="BAdd" 	value="Add" type="button" size="10" maxlength="10"
                onclick="OnClick_Header(this.form.x, this.form.y, this.form.z)"/>
                <input 	name="z" id="z" type="text" value="0" />
        </form>

        <b> AJAX Example (XML) </b>
        <form name="FXML" action="#" method="POST">
                <input name="n" type="text" value="0" size="2" maxlength="2" />
                <input name="BRand" value="Rand" type="button" size="10" maxlength="10"
                onclick="OnClick_XML(this.form.n.value,
                document.getElementById('xml'))" />
                <span id="xml" class="h2">.....</span>
        </form>

        <b> AJAX Example (JSON) </b>
        <form name="FXML" action="#" method="POST">
        <input name="n" type="text" value="0" size="2" maxlength="2" />
        <input name="BRand" value="Rand" type="button" size="10" maxlength="10"
        onclick="OnClick_XML(this.form.n.value,
        document.getElementById('json'))" />
        <span id="json" class="h2">.....</span>
        </form>

        <a href="http://localhost:80/lab11/task4.jsp">task 4</a>
<script>

function OnClick_Header(x,y, z) {
        const req = new XMLHttpRequest();
        var patern = new RegExp(/^[0-9]*\.?[0-9]+$/);
        if (patern.test(x.value) && patern.test(y.value)){
                if (req){
                        req.open("POST","http://localhost:80/lab11/Sss_header", true);
                        req.onreadystatechange = function(){
                                if (req.readyState == 4){
                                        if (req.status == 200) {
                                                z.value=req.getResponseHeader("Value-Z");
                                        }
                                        else alert("status = "+ req.status +"\n"+req.statusText);
                                }
                        };
                        req.setRequestHeader("Value-X",  x.value);
                        req.setRequestHeader("Value-Y",  y.value);
                        req.send("null");
                }
        }else alert ("error");
}


function Fill(req){
        var xmldoc = req.responseXML;
        var  tsnum = xmldoc.getElementsByTagName("num");

        var rc = "";
        for (var i = 0; i < tsnum.length; i++){
                rc += tsnum[i].innerHTML+", ";
        }
        return (rc);
}


function OnClick_XML(n, s){
        const req = new XMLHttpRequest();
        var patern = new RegExp(/^[1-9]+[0-9]*$/);
        if (patern.test(n)){
                if (req){
                        req.open("POST","http://localhost:80/lab11/Sss_XML", true);
                        req.onreadystatechange = function(){
                                if (req.readyState == 4){
                                        if (req.status == 200){
                                                s.firstChild.data = Fill(req);
                                                s.className ="h1";
                                        }else alert("status = "+
                                        req.status +"\n"+req.statusText);
                                }
                        };
                        req.setRequestHeader("XRand-N",  n);
                        req.send("null");
                }
        }else alert ("error");
}


function Fill_JSON(req){
        var  xx = eval('('+req.responseText+')');
        var rc = "";
        for (var i = 0; i < xx.X.length; i++){
        rc += (xx.X[i].rand +" ");
        }
        return (rc);
};

function OnClick_JSON(n, s){
        const req = new XMLHttpRequest();
        var patern = new RegExp(/^[1-9]+[0-9]*$/);
        if (patern.test(n)){
                if (req){
                        req.open("POST","http://localhost:80/lab11/Sss_JSON", true);
                        req.onreadystatechange = function(){
                                if (req.readyState == 4){
                                        if (req.status == 200){
                                                s.firstChild.data =
                                                Fill_JSON(req);
                                                s.className ="h1";
                                        }else alert("status = "+
                                        req.status +"\n"+req.statusText);
                                }
                        };
                        req.setRequestHeader("XRand-N",  n);
                        req.send("null");
                }
        }else alert ("error");
};



</script>
</body>
