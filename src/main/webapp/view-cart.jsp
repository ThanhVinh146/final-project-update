<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">

  <title>
    Giftos
  </title>

  <!-- slider stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
  <link href="css/general.css" rel="stylesheet" />
  
</head>

<body>
  <div class="hero_area">
    <!-- header section strats -->
    
     <jsp:include page="header-section.jsp"/>
     
    <!-- end header section -->    
  
  </div>
  <!-- end hero area -->

  <!-- shop section -->

  <section class="shop_section layout_padding">
    <div class="container">
      <div class="heading_container heading_center">
        <h2 class="cart-heading"> Your Cart  </h2>
        
      </div>
      <div class="row">
		<c:forEach items="${cart.getItems()}" var="item">
       <div class="col-sm-6 col-md-4 col-lg-3">
          <div class="box">
            <a href="Details?productId=${item.key.id}">
              <div class="img-box">
                <img src="images/${item.key.imgName}" alt="">
              </div>
              <div class="detail-box">
                <h6>
                  ${item.key.name}
                </h6>
                <h6>
                  Quantity<span>$${item.value}</span>
                  Price <span>$${item.key.price}</span>
                </h6>
              </div>
            </a>
          </div>
        </div>
        </c:forEach>
				
				<c:if test="${empty cart.getItems()}">
				<h4>Cart is empty</h4>
				</c:if>
			</div>
			
		 <div class="row">
			<c:if test="${not empty cart.getItems()}">
			<h4 id="cart-total">Total: ${cart.getTotal()}</h4>			
			</c:if>
		</div>
	</div>
			
	   
		
	
	
  </section>
  

  <!-- end shop section -->

  <!-- info section -->

   

  <!-- end info section -->


  

  

</body>

</html>