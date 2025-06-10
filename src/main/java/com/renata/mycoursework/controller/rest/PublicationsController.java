package com.renata.mycoursework.controller.rest;

import com.renata.mycoursework.controller.request.publications.PublicationsCreateRequest;
import com.renata.mycoursework.controller.request.publications.PublicationsUpdateRequest;
import com.renata.mycoursework.entity.Achievements;
import com.renata.mycoursework.entity.Publications;
import com.renata.mycoursework.service.PublicationsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/publications")
public class PublicationsController {

    private final PublicationsService publicationsService;

    public PublicationsController(PublicationsService publicationsService) {
        this.publicationsService = publicationsService;
    }

    @Operation(
            summary = "Отобразить все возможные публикации",
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
    public ResponseEntity<List<Publications>> findAll() {
        return new ResponseEntity<>(publicationsService.findAll(), HttpStatus.OK);
    }


    @Operation(
            summary = "Найти публикацию по id",
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
    public ResponseEntity<Optional<Publications>> findById(@Parameter(name = "id", example = "1", required = true) @PathVariable Long id) {
        return new ResponseEntity<>(publicationsService.findById(id), HttpStatus.OK);
    }


    @Operation(
            summary = "Создать новую запись про публикацию",
            parameters = {
                    @Parameter(
                            name = "title",
                            description = "Название",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "year",
                            description = "Год издания",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "number")
                    ),
                    @Parameter(
                            name = "link",
                            description = "Ссылка на публикацию",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "personId",
                            description = "ID сотрудника",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "number")
                    )
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
    public ResponseEntity<Publications> create(@Parameter(hidden = true) @Valid @ModelAttribute PublicationsCreateRequest publicationsCreateRequest) {
        return new ResponseEntity<>(publicationsService.create(publicationsCreateRequest), HttpStatus.CREATED);
    }


    @Operation(
            summary = "Изменить запись публикации по id",
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
                            name = "title",
                            description = "Название",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "year",
                            description = "Год издания",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "number")
                    ),
                    @Parameter(
                            name = "link",
                            description = "Ссылка на публикацию",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "personId",
                            description = "ID сотрудника",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "number")
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Изменение информации о публикации",
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
    public ResponseEntity<Publications> update(@Parameter(hidden = true) @Valid @ModelAttribute PublicationsUpdateRequest publicationsUpdateRequest) {
        return new ResponseEntity<>(publicationsService.update(publicationsUpdateRequest), HttpStatus.OK);
    }


    @Operation(
            summary = "Удалить публикацию по ID",
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
    public ResponseEntity<Publications> delete(@Parameter(name = "id", example = "1", required = true) @PathVariable Long id) {
        publicationsService.delete(id); return new ResponseEntity<>(HttpStatus.OK);
    }
}
