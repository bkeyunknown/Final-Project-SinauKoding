package sinau.project.Human.Resource.information.System.controller;

import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("isFullyAuthenticated()")
public class BaseController {
}
