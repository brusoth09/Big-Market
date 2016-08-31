<%@ include file="/common/taglibs.jsp" %>
<head>
    <title>Preview</title>
</head>
<body>
<div align="center">
    <br>
    <div id="cover-image" style="background-image: url(${post.image_path})">
        <h1>${post.title}</h1>
    </div>
    <h3>${post.content}</h3>
</div>
</body>

