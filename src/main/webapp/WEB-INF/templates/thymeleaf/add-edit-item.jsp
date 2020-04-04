
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
 <meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Add/edit Item</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
</head>
<body bgcolor="#E6E6FA">
 <div class="container my-5">
    <a href="/">Home page</a>
     <center>  <h3> Add Item</h3></center> 
        <div class="card">
            <div class="card-body">
                <div class="col-md-10">
                    <form action="#" th:action="@{/createItem}" th:object="${item}"
                                                                       method="post">
                        <div class="row">
                            <div class="form-group col-md-8">
                                <label for="name" class="col-form-label">Item Name</label> 
                                <input type="text" th:field="*{item_name}" class="form-control"
                                            id="item_name" placeholder="Item Name" />
                            </div>
                            <div class="form-group col-md-8">
                                <label for="name" class="col-form-label">Item Description</label> 
                                <input type="text" th:field="*{item_desc}" class="form-control"
                                            id="item_desc" placeholder="Item Description" />
                            </div>
                            <div class="form-group col-md-8">
                                <label for="email" class="col-form-label">Quantity of Item</label> 
                                <input type="text" th:field="*{item_quantity}" class="form-control"
                                            id="item_quantity" placeholder="Item Quantity" />
                            </div>
  							<div class="form-group col-md-8">
                                <label for="email" class="col-form-label">Item price</label> 
                                <input type="text" th:field="*{item_price}" class="form-control"
                                            id="item_price" placeholder="Item Price" />
                            </div>
 
 
                            <div class="col-md-6">
                                <input type="submit" class="btn btn-primary" value=" Submit ">
                            </div>
 
                            <input type="hidden" id="item_id" th:field="*{item_id}">
     
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>