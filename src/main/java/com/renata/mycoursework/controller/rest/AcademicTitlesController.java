package com.renata.mycoursework.controller.rest;


import com.renata.mycoursework.controller.request.academicTitles.AcademicTitlesCreateRequest;
import com.renata.mycoursework.controller.request.academicTitles.AcademicTitlesUpdateRequest;
import com.renata.mycoursework.entity.AcademicTitles;
import com.renata.mycoursework.service.AcademicTitlesService;
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
@RequestMapping("/academicTitles")
public class AcademicTitlesController {

    private final AcademicTitlesService academicTitlesService;

    public AcademicTitlesController(AcademicTitlesService academicTitlesService) {
        this.academicTitlesService = academicTitlesService;
    }

    @Operation(
            summary = "Отобразить все возможные учёные звания и людей, к которым они относятся",
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
    public ResponseEntity<List<AcademicTitles>> findAll() {
        return new ResponseEntity<>(academicTitlesService.findAll(), HttpStatus.OK);
    }


    @Operation(
            summary = "Найти всех выдающихся людей по учёному званию",
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
    public ResponseEntity<Optional<AcademicTitles>> findById(@Parameter(name = "id", example = "1", required = true) @PathVariable Long id) {
        return new ResponseEntity<>(academicTitlesService.findById(id), HttpStatus.OK);
    }


    @Operation(
            summary = "Создать новое учёное звание",
            parameters = {
                    @Parameter(
                            name = "name",
                            description = "название",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "shortName",
                            description = "сокращённое название",
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
    @PostMapping
    public ResponseEntity<AcademicTitles> create(@Parameter(hidden = true) @Valid @ModelAttribute AcademicTitlesCreateRequest academicTitlesCreateRequest) {
        return new ResponseEntity<>(academicTitlesService.create(academicTitlesCreateRequest), HttpStatus.CREATED);
    }


    @Operation(
            summary = "Изменить информацию об ученом звании",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "ID",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    example = "3",
                                    type = "number")
                    ),
                    @Parameter(
                            name = "name",
                            description = "название",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(
                                    requiredMode = Schema.RequiredMode.REQUIRED,
                                    type = "string")
                    ),
                    @Parameter(
                            name = "shortName",
                            description = "сокращённое название",
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
                            description = "Изменение информации об учёном звании в базе данных",
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

    public ResponseEntity<AcademicTitles> update(@Parameter(hidden = true) @Valid @ModelAttribute AcademicTitlesUpdateRequest academicTitlesUpdateRequest) {
        return new ResponseEntity<>(academicTitlesService.update(academicTitlesUpdateRequest), HttpStatus.OK);
    }


    @Operation(
            summary = "Удалить учёное звание по ID",
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
    public ResponseEntity<AcademicTitles> delete(@Parameter(name = "id", example = "1", required = true) @PathVariable Long id) {
        academicTitlesService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}