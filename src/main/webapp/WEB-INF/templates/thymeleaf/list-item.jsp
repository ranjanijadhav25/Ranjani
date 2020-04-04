
<!DOCTYPE html>
   <html 
    xmlns:th="http://www.thymeleaf.org" 
    xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
    
    <head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>List Of Items</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">

</head>
<body bgcolor="#E6E6FA">

 <div class="container my-2">
    <div class="card">
    <div class="card-body">
        <div th:switch="${items}" class="container my-5">
            <p class="my-5">
                            <a href="/">Home page</a>
                
              <center> <h1><i> List of All Items </i></h1>  </center>
            </p>
            <div class="col-md-10">
                <h2 th:case="null">No record found !!</h2>
                <div th:case="*">
                    <table class="table table-striped table-responsive-md">
                        <thead>
                            <tr>
                                <th>Item Id</th>
                                <th>Item Name</th>
                                <th>Item Description</th>
                                <th>Item Quantity</th>
                                <th>Item price</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr th:each="item : ${items}">
                            	
                                <td th:text="${item.item_id}"></td>
                                <td th:text="${item.item_name}"></td>
                                <td th:text="${item.item_desc}"></td>
                                <td th:text="${item.item_quantity}"></td>
                                <td th:text="${item.item_price}"></td>
                              <td>
                                    <a th:href="@{/edit/{id}(id=${item.item_id})}"
                                             class="btn btn-primary">
                                        <i class="fas fa-user-edit ml-2"></i>
                                    </a>
                                </td>
                                <td>
                                    <a th:href="@{/delete/{id}(id=${item.item_id})}"
                                              class="btn btn-primary">
                                        <i class="fas fa-user-times ml-2"></i>
                                    </a>
                                </td>
                
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