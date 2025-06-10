package com.renata.mycoursework.controller.rest;

import com.renata.mycoursework.controller.request.scientificFields.ScientificFieldsCreateRequest;
import com.renata.mycoursework.controller.request.scientificFields.ScientificFieldsUpdateRequest;
import com.renata.mycoursework.entity.ScientificFields;
import com.renata.mycoursework.service.ScientificFieldsService;
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
@RequestMapping("/scientificFields")
public class ScientificFieldsController {

    private final ScientificFieldsService scientificFieldsService;

    public ScientificFieldsController(ScientificFieldsService scientificFieldsService) {
        this.scientificFieldsService = scientificFieldsService;
    }

    @Operation(
            summary = "Отобразить все возможные научные направления и людей, к которым они относятся",
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
    public ResponseEntity<List<ScientificFields>> findAll() {
        return new ResponseEntity<>(scientificFieldsService.findAll(), HttpStatus.OK);
    }


    @Operation(
            summary = "Найти всех выдающихся людей по научному направлению",
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
    public ResponseEntity<Optional<ScientificFields>> findById(@Parameter(name = "id", example = "1", required = true) @PathVariable Long id) {
        return new ResponseEntity<>(scientificFieldsService.findById(id), HttpStatus.OK);
    }


    @Operation(
            summary = "Создать новое научное направление",
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
    public ResponseEntity<ScientificFields> create(@Parameter(hidden = true) @Valid @ModelAttribute ScientificFieldsCreateRequest scientificFieldsCreateRequest) {
        return new ResponseEntity<>(scientificFieldsService.create(scientificFieldsCreateRequest), HttpStatus.CREATED);
    }


    @Operation(
            summary = "Изменить информацию о научном направлении",
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
                            description = "Изменение информации о научном направлении в базе данных",
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

    public ResponseEntity<ScientificFields> update(@Parameter(hidden = true) @Valid @ModelAttribute ScientificFieldsUpdateRequest scientificFieldsUpdateRequest) {
        return new ResponseEntity<>(scientificFieldsService.update(scientificFieldsUpdateRequest), HttpStatus.OK);
    }


    @Operation(
            summary = "Удалить научное направление по ID",
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
    public ResponseEntity<ScientificFields> delete(@Parameter(name = "id", example = "1", required = true) @PathVariable Long id) {
        scientificFieldsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
