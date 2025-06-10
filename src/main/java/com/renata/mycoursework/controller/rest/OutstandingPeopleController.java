package com.renata.mycoursework.controller.rest;
import com.renata.mycoursework.controller.request.outstandingPeople.OutstandingPeopleCreateRequest;
import com.renata.mycoursework.controller.request.outstandingPeople.OutstandingPeopleUpdateRequest;
import com.renata.mycoursework.entity.OutstandingPeople;
import com.renata.mycoursework.entity.enums.Gender;
import com.renata.mycoursework.service.OutstandingPeopleService;
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
@RestController @RequestMapping("/outstandingPeople")
public class OutstandingPeopleController {
    private final OutstandingPeopleService outstandingPeopleService;
    public OutstandingPeopleController(OutstandingPeopleService outstandingPeopleService) {
        this.outstandingPeopleService = outstandingPeopleService;
    }
    @Operation(
            summary = "Отобразить всех выдающихся сотрудников, их достижения и публикации",
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
    public ResponseEntity<List<OutstandingPeople>> findAll() {
        return new ResponseEntity<>(outstandingPeopleService.findAll(), HttpStatus.OK);
    }
    @Operation(
            summary = "Отобразить сотрудника по ID, его достижения и публикации",
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
    public ResponseEntity<Optional<OutstandingPeople>> findById(@Parameter(name = "id", example = "1", required = true)
                                                                    @PathVariable Long id) {
        return new ResponseEntity<>(outstandingPeopleService.findById(id), HttpStatus.OK);
    }
    @Operation(
            summary = "Создание нового сотрудника",
            parameters = {
                    @Parameter(
                            name = "name",
                            description = "Имя",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "surname",
                            description = "Фамилия",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "patronymic",
                            description = "Отчество",
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "gender",
                            description = "Пол",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    example = "NOT_SELECTED",
                                    type = "Gender",
                                    implementation = Gender.class)
                    ),
                    @Parameter(
                            name = "yearOfBirth",
                            description = "Год рождения",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "number")
                    ),
                    @Parameter(
                            name = "yearOfDeath",
                            description = "Год смерти",
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                                    type = "number")
                    ),
                    @Parameter(
                            name = "photoUrl",
                            description = "Ссылка на фото",
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "biography",
                            description = "Краткая биография",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "string")
                    ),




                    @Parameter(
                            name = "academicTitles",
                            description = "Учёное звание",
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "academicDegrees",
                            description = "Учёная степень",
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "scientificFields",
                            description = "Научное направление",
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                                    type = "string")
                    ),
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Внесение в бд сотрудника",
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
    public ResponseEntity<OutstandingPeople> create(@Parameter(hidden = true) @Valid
                                                        @ModelAttribute OutstandingPeopleCreateRequest outstandingPeopleCreateRequest) {
        return new ResponseEntity<>(outstandingPeopleService.create(outstandingPeopleCreateRequest), HttpStatus.CREATED);
    }
    @Operation(
            summary = "Изменить информацию о сотруднике",
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
                            name = "name",
                            description = "Имя",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "surname",
                            description = "Фамилия",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "patronymic",
                            description = "Отчество",
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "gender",
                            description = "Пол",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    example = "NOT_SELECTED",
                                    type = "Gender",
                                    implementation = Gender.class)
                    ),
                    @Parameter(
                            name = "yearOfBirth",
                            description = "Год рождения",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "number")
                    ),
                    @Parameter(
                            name = "yearOfDeath",
                            description = "Год смерти",
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                                    type = "number")
                    ),
                    @Parameter(
                            name = "photoUrl",
                            description = "Ссылка на фото",
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "biography",
                            description = "Краткая биография",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "string")
                    ),




                    @Parameter(
                            name = "academicTitles",
                            description = "Учёное звание",
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "academicDegrees",
                            description = "Учёная степень",
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "scientificFields",
                            description = "Научное направление",
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                                    type = "string")
                    ),
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Изменение информации о сотруднике в базе данных",
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
    public ResponseEntity<OutstandingPeople> update(@Parameter(hidden = true) @Valid
                                                        @ModelAttribute OutstandingPeopleUpdateRequest outstandingPeopleUpdateRequest) {
        return new ResponseEntity<>(outstandingPeopleService.update(outstandingPeopleUpdateRequest), HttpStatus.OK);
    }
    @Operation(
            summary = "Удалить сотрудника по ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Удаление из базы данных сотрудника",
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
    public ResponseEntity<OutstandingPeople> delete(@Parameter(name = "id", example = "1", required = true) @PathVariable Long id) {
        outstandingPeopleService.delete(id); return new ResponseEntity<>(HttpStatus.OK);
    }
}
