<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="web.app.login"/></title>
</head>
<body class="hold-transition login-page">
    <div class="container">
        <c:if test="${not empty error}">
            <div id="error-alert" class="alert alert-danger alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                <h4><i class="icon fa fa-ban"></i> Authentication Failed</h4>
                Entered username or password is wrong! retry again.
            </div>
        </c:if>
        <c:if test="${not empty logout}">
            <div id="success-alert" class="alert alert-success alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                <h4><i class="icon fa fa-check"></i> Logout Successfully!</h4>
                Logout Successfully From Big-Market.
            </div>
        </c:if>
    </div>
<div class="login-box">
    <div class="login-logo">
        <a href="../../index2.html"><b>Simple</b>CMS</a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">Sign in to start your session</p>

        <form name="loginForm" action="<c:url value='/login' />" method='POST'>
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="Email" name="username">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="Password" name="password">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox"> Remember Me
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
                </div>
                <!-- /.col -->
            </div>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
        </form>
    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });

    $("#success-alert").fadeTo(2000, 500).slideUp(500, function(){
        $("#success-alert").alert('close');
    });

    $("#error-alert").fadeTo(2000, 500).slideUp(500, function(){
        $("#success-alert").alert('close');
    });

</script>
</body>
</html>
