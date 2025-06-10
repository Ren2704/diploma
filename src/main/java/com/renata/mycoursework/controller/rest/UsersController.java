package com.renata.mycoursework.controller.rest;

import com.renata.mycoursework.controller.request.users.UsersCreateRequest;
import com.renata.mycoursework.controller.request.users.UsersUpdateRequest;
import com.renata.mycoursework.entity.Users;
import com.renata.mycoursework.entity.enums.Role;
import com.renata.mycoursework.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @Operation(
            summary = "Отобразить всех пользователей",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Вытягивание из бд данных",
                            content = @Content(
                                    mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректный запрос",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Внутренняя ошибка сервера",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    )
            }
    )
    @GetMapping
    public ResponseEntity<List<Users>> findAll() {
        return new ResponseEntity<>(usersService.findAll(), HttpStatus.OK);
    }


    @Operation(
            summary = "Отобразить пользователя по ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Вытягивание из бд данных",
                            content = @Content(
                                    mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректный запрос",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Внутренняя ошибка сервера",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Users>> findById(@Parameter(name = "id", example = "1", required = true) @PathVariable Long id) {
        return new ResponseEntity<>(usersService.findById(id), HttpStatus.OK);
    }


    @Operation(
            summary = "Создание нового пользователя",
            parameters = {
                    @Parameter(
                            name = "login",
                            description = "Логин",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "password",
                            description = "Пароль",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "role",
                            description = "Роль",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    example = "NOT_SELECTED",
                                    type = "Role",
                                    implementation = Role.class)
                    ),
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Внесение в базу данных пользователя",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректный запрос",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Внутренняя ошибка сервера",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    )
            }
    )
    @PostMapping
    public ResponseEntity<Users> create(@Parameter(hidden = true) @Valid @ModelAttribute UsersCreateRequest usersCreateRequest) {
        return new ResponseEntity<>(usersService.create(usersCreateRequest), HttpStatus.CREATED);
    }


    @Operation(
            summary = "Изменить информацию о пользователе",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "ID",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "number")
                    ),
                    @Parameter(
                            name = "login",
                            description = "Логин",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "password",
                            description = "Пароль",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "role",
                            description = "Роль",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    example = "NOT_SELECTED",
                                    type = "Role",
                                    implementation = Role.class)
                    ),
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Изменение информации о пользователе в базе данных",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректный запрос",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Внутренняя ошибка сервера",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    )
            }
    )
    @PutMapping
    public ResponseEntity<Users> update(@Parameter(hidden = true) @Valid @ModelAttribute UsersUpdateRequest usersUpdateRequest) {
        return new ResponseEntity<>(usersService.update(usersUpdateRequest), HttpStatus.OK);
    }


    @Operation(
            summary = "Удалить пользователя по ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Удаление из базы данных пользователя",
                            content = @Content(
                                    mediaType = "application/json")
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректный запрос",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Внутренняя ошибка сервера",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    )
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Users> delete(@Parameter(name = "id", example = "1", required = true) @PathVariable Long id) {
        usersService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
