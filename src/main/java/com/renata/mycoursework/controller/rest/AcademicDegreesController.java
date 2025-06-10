package com.renata.mycoursework.controller.rest;

import com.renata.mycoursework.controller.request.academicDegrees.AcademicDegreesCreateRequest;
import com.renata.mycoursework.controller.request.academicDegrees.AcademicDegreesUpdateRequest;
import com.renata.mycoursework.entity.AcademicDegrees;
import com.renata.mycoursework.service.AcademicDegreesService;
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
@RequestMapping("/academicDegrees")
public class AcademicDegreesController {

    private final AcademicDegreesService academicDegreesService;

    public AcademicDegreesController(AcademicDegreesService academicDegreesService) {
        this.academicDegreesService = academicDegreesService;
    }

    @Operation(
            summary = "Отобразить все возможные учёные степени и людей, к которым они относятся",
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
    public ResponseEntity<List<AcademicDegrees>> findAll() {
        return new ResponseEntity<>(academicDegreesService.findAll(), HttpStatus.OK);
    }


    @Operation(
            summary = "Найти всех выдающихся людей по учёной степени",
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
    public ResponseEntity<Optional<AcademicDegrees>> findById(@Parameter(name = "id", example = "1", required = true) @PathVariable Long id) {
        return new ResponseEntity<>(academicDegreesService.findById(id), HttpStatus.OK);
    }


    @Operation(
            summary = "Создать новую учёную степень",
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
    public ResponseEntity<AcademicDegrees> create(@Parameter(hidden = true) @Valid @ModelAttribute AcademicDegreesCreateRequest academicDegreesCreateRequest) {
        return new ResponseEntity<>(academicDegreesService.create(academicDegreesCreateRequest), HttpStatus.CREATED);
    }


    @Operation(
            summary = "Изменить информацию об ученой степени",
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
                            description = "Изменение информации об учёной степени в базе данных",
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

    public ResponseEntity<AcademicDegrees> update(@Parameter(hidden = true) @Valid @ModelAttribute AcademicDegreesUpdateRequest academicDegreesUpdateRequest) {
        return new ResponseEntity<>(academicDegreesService.update(academicDegreesUpdateRequest), HttpStatus.OK);
    }


    @Operation(
            summary = "Удалить учёную степень по ID",
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
    public ResponseEntity<AcademicDegrees> delete(@Parameter(name = "id", example = "1", required = true) @PathVariable Long id) {
        academicDegreesService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
