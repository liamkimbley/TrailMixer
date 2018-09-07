<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trail Mixer</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="styles.css">
</head>
<body>

<!-- Navbar -->

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="index.do">Home</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="ListOfTrails.do">Trails</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="profile.do">Profile</a>
            </li>
        </ul>
    </div>
    <div class="mx-auto order-0">
        <a class="navbar-brand mx-auto" href="#">Trail Mixer</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="login.do">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="logout.do">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<!-- Welcome section with carousel -->

<div class="welcome">Welcome to Trail Mixer!</div>
<div id="HikingImages" class="carousel slide carousel-fade" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" width="100%" src="http://coloradoadventureswithkids.com/wp-content/uploads/2017/08/vaca-29-of-37.jpg" alt="Hanging Lakes" height="550px">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" width="100%" src="https://www.visitmontrose.com/ImageRepository/Document?documentID=898" alt="Second Slide" height="550px">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" width="100%" src="https://c1.staticflickr.com/4/3691/33177152415_94e7588b2c_b.jpg" alt="Third slide" height="550px">
    </div>
  </div>
  <a class="carousel-control-prev" href="#HikingImages" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#HikingImages" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

<br>

<!-- About us section -->

  <section id="about">
    <div class="container wow fadeInUp">
      <div class="row">
        <div class="col-md-12">
          <h3 class="section-title">About Trail Mixer</h3>
          <div class="section-title-divider"></div>
        </div>
      </div>
    </div>
    <div class="container about-container wow fadeInUp">
      <div class="row">

        <div class="col-lg-6 about-img">
          <img src="image/holding hands.jpg" alt="People Hiking together and loving it">
        </div> 

        <div class="col-md-6 about-content">
          <h2 class="about-title">	Uniting a special group of people to do some of the things they love.</h2>
          <p class="about-text">
            Most of us live in urban areas, in busy cities where nature is tamed and does not take an important place in daily life.
             However, nature is more than just a place we can visit during our holidays or weekends. Nature is our origin and the place where all our subtle needs for beauty, mystery, and adventure are met. 
             Nature holds many gifts for us if we prove willing to explore its magnificent diversity.  Here on Trail Mixer, we pride ourselves on
             joining individuals with a huge community of people with similar interests. That being from adventure seekers looking to explore, people who are all about excerise, others who want hike a 14er, or just find a nice place to cliff jump, it is an endless trail of possibilities! 

          </p>
         
          <p class="about-text">
            A place were people find their best friends, their lovers, and the light in their life.
          </p>
          <a href="SignUp.do" class="btn btn-dark" role="button" aria-pressed="true">Sign Up Now</a>
        </div>
      </div>
    </div>
  </section>
  
  
<!-- Our team section -->

  <section id="team">
    <div class="container wow fadeInUp">
      <div class="row">
        <div class="col-md-12">
          <h3 class="section-title-team">Our Team</h3>
          <div class="section-title-divider"></div>
          <p class="section-description">Trail Mixer has an incredible team behind it, all different backgrounds and personalities that mesh together through the power of mild similar interests</p>
        </div>
      </div>

      <div class="row">
        <div class="col-md-3">
          <div class="member">
            <div class="pic"><img src="image/isaacHike.jpg" alt="Isaac Sunoo"></div>
            <h4>Isaac Sunoo</h4>
            <span>Chief Executive Officer</span>	
            <div class="social">
              <a href=""><i class="fa fa-twitter"></i></a>
              <a href=""><i class="fa fa-facebook"></i></a>
              <a href=""><i class="fa fa-google-plus"></i></a>
              <a href=""><i class="fa fa-linkedin"></i></a>
            </div>
          </div>
        </div>

        <div class="col-md-3">
          <div class="member">
            <div class="pic"><img src="image/OwenHarris.jpg" alt="Owen Harris"></div>
            <h4>Owen Harris</h4>
            <span>Chief Technical Officer</span>
            <div class="social">
              <a href=""><i class="fa fa-twitter"></i></a>
              <a href=""><i class="fa fa-facebook"></i></a>
              <a href=""><i class="fa fa-google-plus"></i></a>
              <a href=""><i class="fa fa-linkedin"></i></a>
            </div>
          </div>
        </div>

        <div class="col-md-3">
          <div class="member">
            <div class="pic"><img src="image/LiamKimbley.jpg" alt="Liam Kimbley"></div>
            <h4>Liam Kimbley</h4>
            <span>Chief Financial Officer</span>
            <div class="social">
              <a href=""><i class="fa fa-twitter"></i></a>
              <a href=""><i class="fa fa-facebook"></i></a>
              <a href=""><i class="fa fa-google-plus"></i></a>
              <a href=""><i class="fa fa-linkedin"></i></a>
            </div>
          </div>
        </div>
        
        <div class="col-md-3">
          <div class="member">
            <div class="pic"><img src="image/OllieHike.jpg" alt="Ollie Dog"></div>
            <h4>Ollie</h4>
            <span>Mascot</span>
            <div class="social">
              <a href=""><i class="fa fa-twitter"></i></a>
              <a href=""><i class="fa fa-facebook"></i></a>
              <a href=""><i class="fa fa-google-plus"></i></a>
              <a href=""><i class="fa fa-linkedin"></i></a>
            </div>
          </div>
        </div>

      </div>
    </div>
  </section>
	
	
	
  <section id="contact">
    <div class="container wow fadeInUp">
      <div class="row">
        <div class="col-md-12">
          <h3 class="section-title">Contact Us</h3>
          <div class="section-title-divider"></div>
          <p class="section-description">Any personal inquires on the site please reach out to us!</p>
        </div>
      </div>

      <div class="row">
        <div class="col-md-3 col-md-push-2">
          <div class="info">
            <div>
              <i class="fa fa-map-marker"></i>
              <p>7400 E Orchard Rd #1450n<br>GreenWood Village, CO 80111</p>
            </div>

            <div>
              <i class="fa fa-envelope"></i>
              <p>trailmixer@gmail.com</p>
            </div>

            <div>
              <i class="fa fa-phone"></i>
              <p>555.555.5555</p>
            </div>

          </div>
        </div>

        <div class="col-md-5 col-md-push-2">
          <div class="form">
            <div id="sendmessage">Your message has been sent. Thank you!</div>
            <div id="errormessage"></div>
            <form action="" method="post" role="form" class="contactForm">
              <div class="form-group">
                <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                <div class="validation"></div>
              </div>
              <div class="form-group">
                <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" data-rule="email" data-msg="Please enter a valid email" />
                <div class="validation"></div>
              </div>
              <div class="form-group">
                <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" />
                <div class="validation"></div>
              </div>
              <div class="form-group">
                <textarea class="form-control" name="message" rows="5" data-rule="required" data-msg="Please write something for us" placeholder="Message"></textarea>
                <div class="validation"></div>
              </div>
              <div class="text-center"><button type="submit">Send Message</button></div>
            </form>
          </div>
        </div>

      </div>
    </div>
  </section>
  
  
    <footer id="footer">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="copyright">
            &copy; Copyright <strong>Isaac, Liam, Owen Inc</strong>. All Rights Reserved
          </div>
          <div class="credits">
          </div>
        </div>
      </div>
    </div>
  </footer>
	
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>