<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="header.jsp" />

<body>
	<h2>
		<s:text name="welcome" />
	</h2>

	<table>
		<s:iterator value="flights">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="departure" /></td>
				<td><s:property value="arrival" /></td>
			</tr>
		</s:iterator>
	</table>
</body>


<s:include value="footer.jsp" />

