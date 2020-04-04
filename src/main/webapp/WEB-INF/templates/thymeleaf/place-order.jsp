<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
 <meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Place Order</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">

</head>
<body bgcolor="#E6E6FA">
 <div class="container my-5">
 <a href="/">Home page</a>
        <center><h3> Place Order for the items</h3></center>
        <div class="card">
            <div class="card-body">
                <div class="col-md-10">
                    <form action="#" th:action="@{/placeitemorder}" th:object="${order}"
                                                                       method="post">
                        <div class="row">
                           <!--  <div class="form-group col-md-8">
                                <label for="name" class="col-form-label">Item Name</label> 
                                <input type="text" th:field="*{item_name}" class="form-control"
                                            id="item_name" placeholder="Item Name" />
                            </div> -->
                            
                            
                              <div class="form-group col-md-8">
						*Select item from the list : <select th:field="*{item_name}" class="form-control" id="selecteditem">
								<option value="">Select</option>
								<option th:each="item_name : ${itemList}" th:value="${item_name}"
									th:text="${item_name}"></option>
							</select>
							 
						</div>
                            
                            <!-- 
                            
                    
                             
                             
                            
                                            <div class="form-group col-md-4">
						*Select appropriate APS Workgroup : <select th:field="*{workgroupName}" class="form-control" id="selectedworkgroup">
								<option value="">Select</option>
								<option th:each="workgroupName : ${workgroupList}" th:value="${workgroupName}"
									th:text="${workgroupName}"></option>
							</select>
							 <label th:if="${#fields.hasErrors('workgroupName')}" th:errors="*{workgroupName}"
								class="validation-message"></label>
						</div>
						
                             -->
                            
                            <div class="form-group col-md-8">
                                <label for="name" class="col-form-label">Number of Items</label> 
                                <input type="text" th:field="*{no_of_items}" class="form-control"
                                            id="no_of_items" placeholder="Number of Items" />
                            </div>
                            <div class="form-group col-md-8">
                                <label for="email" class="col-form-label">Email id</label> 
                                <input type="email" th:field="*{email_id}" class="form-control"
                                            id="email_id" placeholder="Email Id" />
                                            
                               
                            </div>
  							
 
                            <div class="col-md-6">
                                <input type="submit" class="btn btn-primary" value=" Submit ">
                            </div>
 
                           <!--   <input type="hidden" id="order_id" th:field="*{order_id}">-->
     
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>