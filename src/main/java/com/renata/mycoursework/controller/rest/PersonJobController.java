package com.renata.mycoursework.controller.rest;

import com.renata.mycoursework.controller.request.personJob.PersonJobCreateRequest;
import com.renata.mycoursework.controller.request.personJob.PersonJobUpdateRequest;
import com.renata.mycoursework.entity.PersonJob;
import com.renata.mycoursework.service.PersonJobService;
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
@RestController @RequestMapping("/personJob")
public class PersonJobController {

    private final PersonJobService personJobService;

    public PersonJobController(PersonJobService personJobService) {
        this.personJobService = personJobService;
    }


    @Operation(
            summary = "Отобразить все периоды, когда сотрудники работали в университете",
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
    public ResponseEntity<List<PersonJob>> findAll() {
        return new ResponseEntity<>(personJobService.findAll(), HttpStatus.OK);
    }


    @Operation(
            summary = "Найти по id определённый период",
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
    public ResponseEntity<Optional<PersonJob>> findById(@Parameter(name = "id", example = "1", required = true) @PathVariable Long id) {
        return new ResponseEntity<>(personJobService.findById(id), HttpStatus.OK);
    }


    @Operation(
            summary = "Создать новую связующую запись про период работы сотрудника на определённой должности",
            parameters = {
                    @Parameter(
                            name = "startYear",
                            description = "В каком году сотрудник получил должность",
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                                    type = "number")
                    ),
                    @Parameter(
                            name = "endYear",
                            description = "В каком году сотрудник был снят с должности",
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                                    type = "number")
                    ),
                    @Parameter(
                            name = "isCurrent",
                            description = "Актуальна ли должность",
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    type = "boolean",
                                    defaultValue = "false",
                                    allowableValues = {"true", "false"}
                            )
                    ),
                    @Parameter(
                            name = "personId",
                            description = "ID сотрудника",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "number")
                    ),
                    @Parameter(
                            name = "jobTitle",
                            description = "Название должности",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "string")
                    ),
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Внесение в бд данных",
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
    public ResponseEntity<PersonJob> create(@Parameter(hidden = true) @Valid @ModelAttribute PersonJobCreateRequest personJobCreateRequest) {
        return new ResponseEntity<>(personJobService.create(personJobCreateRequest), HttpStatus.CREATED);
    }


    @Operation(
            summary = "Изменить по id связующую запись про период работы сотрудника на определённой должности",
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
                            name = "startYear",
                            description = "В каком году сотрудник получил должность",
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                                    type = "number")
                    ),
                    @Parameter(
                            name = "endYear",
                            description = "В каком году сотрудник был снят с должности",
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                                    type = "number")
                    ),
                    @Parameter(
                            name = "isCurrent",
                            description = "Актуальна ли должность",
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    type = "boolean",
                                    defaultValue = "false",
                                    allowableValues = {"true", "false"}
                            )
                    ),
                    @Parameter(
                            name = "personId",
                            description = "ID сотрудника",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "number")
                    ),
                    @Parameter(
                            name = "jobTitle",
                            description = "Название должности",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "string")
                    ),
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Изменение информации о записи",
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
    public ResponseEntity<PersonJob> update(@Parameter(hidden = true) @Valid @ModelAttribute PersonJobUpdateRequest personJobUpdateRequest) {
        return new ResponseEntity<>(personJobService.update(personJobUpdateRequest), HttpStatus.OK);
    }


    @Operation(
            summary = "Удалить должность по ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Удаление из базы данных",
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
    public ResponseEntity<PersonJob> delete(@Parameter(name = "id", example = "1", required = true) @PathVariable Long id) {
        personJobService.delete(id); return new ResponseEntity<>(HttpStatus.OK);
    }
}
