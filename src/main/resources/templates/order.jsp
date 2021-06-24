
<html xmlns:th="http://www.thymeleaf.org">

<body>
    <form action="/posts" method="POST">
        Count: <input name="count"> <br>
        Address: <input name="address"> <br>
        <input type="hidden"
            th:name="${_csrf.parameterName}"
            th:value="${_csrf.token}" />
        <input type="submit" value="ok">
    </form>
</body>

</html>