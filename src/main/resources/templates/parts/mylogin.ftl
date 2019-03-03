<#macro login path>
<link rel="stylesheet"
      href="/static/css/login.css"/>

<div class="loginbox">
    <h1>Login page</h1>
    <form method="post" action="/mylogin">
        <p>Username</p>
        <input type="text" name="username" placeholder="Enter Username" value="<#if user??>user.username</#if>">
        <p>Password</p>
        <input type="password" name="password" placeholder="Enter Password">
        <input type="submit" name="submit" value="Login">
        <#--<input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
        <a href="#">Lost your password?</a><br>
        <a href="/registration">Don't have an account?</a>
    </form>


</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <#--<input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
        <input type="submit" value="Sign Out"/>
    </form>
</#macro>


<#macro registration path>
    <link rel="stylesheet"
          href="/static/css/registration.css"/>
    <div id="login-box">

        <div class="left-box">
            <h1> Sign Up</h1>
            <h1 class ="message">  </h1>
            <form id="registrationForm" action="/registration" method="post" >
                <p class="usernameMessage"> </p>
                <input type="text" name="username" placeholder="Username"/>
                <p class="emailMessage"> </p>
                <input type="email" name="email" placeholder="Email"/>
                <p class="passwordMessage"> </p>
                <input type="password" name="password" placeholder="Password"/>
                <input type="password" name="password2" placeholder="Retype password"/>
                <input type="date" name="birthDate"/>
                <input type="radio" name="gender" value="male"/>
                <input type="radio" name="gender" value="female"/>
                <#--<input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
                <input type="submit" name="submit" value="Sign Up" />

            </form>
        </div>
        <div class="right-box">
            <span class="signinwith">Sign in with<br/>Social Network     </span>

            <button class="social facebook">Log in with Facebook</button>
            <button class="social twitter">Log in with Twitter</button>
            <button class="social google">Log in with Google+</button>


        </div>
        <div class="or">OR</div>
    </div>
</#macro>








<#--<form action="${path}" method="post">-->
<#--<div><label> User Name : <input type="text" name="username"/> </label></div>-->
<#--<div><label> Password: <input type="password" name="password"/> </label></div>-->
<#--<div><label> Email: <input type="text" name="email"/> </label></div>-->
<#--<div><label> Birth date: <input type="date" name="birthDate"/> </label></div>-->
<#--<div><label> Male <input type="radio" name="gender" value="male"/> </label></div>-->
<#--<div><label> Female <input type="radio" name="gender" value="female"/> </label></div>-->


<#--<input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
<#--<div><input type="submit" value="Sign In"/></div>-->
<#--</form>-->
