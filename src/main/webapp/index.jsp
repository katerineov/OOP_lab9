<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Аренда фототехники PhotoGear</title>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<div class="add-rent-container">
    <form class="content-form" action="${pageContext.request.contextPath}/rents" method="post">
        <h1>Новая аренда</h1>
        <table>
            <tr>
                <td>Имя покупателя:</td>
                <td><input type="text" name="Name" required></td>
            </tr>
            <tr>
                <td>Номер телефона:</td>
                <td><input type="text" name="PhoneNumber" required></td>
            </tr>
            <tr>
                <td>Дата аренды:</td>
                <td><input type="text" name="RentDate" required></td>
            </tr>
            <tr>
                <td>Наименование товара:</td>
                <td><input type="text" name="ProductName" required></td>
            </tr>
            <tr>
                <td>Стоимость аренды:</td>
                <td><input type="number" step="0.1" name="Price" required></td>
            </tr>
            <tr>
                <td>Длительность аренды:</td>
                <td><input type="text" name="Duration" required></td>
            </tr>
            <tr>
                <td colspan="2"><input class="btn" type="submit" value="Добавить"></td>
            </tr>
        </table>
    </form>
</div>
<c:if test="${empty rents and empty param.loadjson}">
    <c:redirect url="/rents?loadjson=true"/>
</c:if>
<div class="list-rents-container">
<h1>Список арендованных товаров</h1>
    <table class="list-rents">
        <tr>
            <th class="cell-list">Имя покупателя</th>
            <th class="cell-list">Номер телефона</th>
            <th class="cell-list">Дата аренды</th>
            <th class="cell-list">Наименование товара</th>
            <th class="cell-list">Стоимость аренды</th>
            <th class="cell-list">Длительность</th>
        </tr>
        <c:forEach var="rent" items="${rents}">
            <tr>
                <td class="cell-list">${rent.name}</td>
                <td class="cell-list">${rent.phoneNumber}</td>
                <td class="cell-list">${rent.rentDate}</td>
                <td class="cell-list">${rent.productName}</td>
                <td class="cell-list">${rent.price}</td>
                <td class="cell-list">${rent.duration}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>