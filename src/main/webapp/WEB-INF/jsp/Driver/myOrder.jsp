<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp"%>



<c:if test="${myOrder eq null}">
    <div>В данный момент у вас нет ни одного зазаза</div>
</c:if>


<c:if test="${myOrder != null}">
    <H2>Заказ № <c:out value="${myOrder.id}"/></H2>



    <h3>Позиции в заказе</h3>
    <table class = "table bordered-table hover-table">
        <tr>
            <th>Наименование</th>
            <th>Вес</th>
            <th>Координаты доставки</th>
            <th>Статус доставки</th>
        </tr>
        <c:forEach items="${myOrder.items}" var="item">
            <tr>
                <td>
                    <c:out value="${item.name}"/>
                </td>
                <td>
                    <c:out value="${item.weight}"/>
                </td>
                <td>
                    <c:out value="${item.latitude}"/>;
                    <c:out value="${item.longitude}"/>
                </td>
                <td>

                    <c:if test="${item.delivery eq 'NOT_DELIVERED'}">
                        <a href="<spring:url value="/Driver/${item.id}/deliver.html" /> " >
                        Доставить
                        </a>
                    </c:if>
                    <c:if test="${item.delivery eq 'DELIVERED'}">
                        Груз доставлен
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

