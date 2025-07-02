package org.example.married.domain.user.presentation.impl

import org.example.married.domain.user.domain.facade.UserFacade
import org.example.married.domain.user.presentation.QueryUserController
import org.example.married.domain.user.presentation.dto.response.UserInfoResponse
import org.example.married.domain.user.service.QueryUserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class QueryUserControllerImpl(
    private val queryUserService: QueryUserService
): QueryUserController {

    @GetMapping
    override fun getUserInfo(): ResponseEntity<UserInfoResponse> {
        val result = queryUserService.getUserInfo(UserFacade.getCurrentUser())
        return ResponseEntity.ok(result)
    }
}