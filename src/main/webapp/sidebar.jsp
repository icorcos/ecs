<nav class="col-md-2 d-none d-md-block bg-light sidebar">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link active" href="${pageContext.request.contextPath}/action/dashboard"><span
                        class="fas fa-home"></span> Home <span class="sr-only">(current)</span></a>
            </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
            <span>Configuration</span><a class="d-flex align-items-center text-muted" href="#"></a>
        </h6>

        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/action/settings"><span
                        class="fas fa-cog"></span> Settings</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"><span class="fas fa-clone"></span> Message Templates</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"><span class="fas fa-share-alt"></span> Interfaces</a>
            </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
            <span>Reports</span><a class="d-flex align-items-center text-muted" href="#"></a>
        </h6>
        <ul class="nav flex-column mb-2">
            <li class="nav-item">
                <a class="nav-link" href="#"><span class="far fa-file-alt"></span> All active interfaces</a>
            </li>
        </ul>
    </div>
</nav>