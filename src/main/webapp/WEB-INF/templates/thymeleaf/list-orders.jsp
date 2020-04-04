
<!DOCTYPE html>
   <html 
    xmlns:th="http://www.thymeleaf.org" 
    xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<title>List of Orders</title>
   <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">

</head>
<body bgcolor="#E6E6FA">
<div class="container my-2">
    <div class="card">
    <div class="card-body">
        <div th:switch="${orders}" class="container my-5">
            <p class="my-5">
                            <a href="/">Home page</a>
                
              <center> <h1><i> List of All Orders </i></h1>  </center>
            </p>
            <div class="col-md-10">
                <h2 th:case="null">No record found !!</h2>
                <div th:case="*">
                    <table class="table table-striped table-responsive-md">
                        <thead>
                            <tr>
                                <th>Order Id</th>
                                <th>Item Name</th>
                                <th>Number of items ordered</th>
                                <th>Customer Email id</th>
                               <th>Order Amount</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            <tr th:each="order : ${orders}">
                            	
                                <td th:text="${order.order_id}"></td>
                                <td th:text="${order.item_name}"></td>
                                <td th:text="${order.no_of_items}"></td>
                                <td th:text="${order.email_id}"></td>
                                 <td th:text="${order.order_amount}"></td>
                             
                
                            </tr>
                        </tbody>
                    </table>
                </div>
 
            </div>
        </div>
    </div>
    </div>
    </div>
</body>
</html>