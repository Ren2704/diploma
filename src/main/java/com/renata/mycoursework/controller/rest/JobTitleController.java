package com.renata.mycoursework.controller.rest;
import com.renata.mycoursework.controller.request.jobTitle.JobTitleCreateRequest;
import com.renata.mycoursework.controller.request.jobTitle.JobTitleUpdateRequest;
import com.renata.mycoursework.entity.JobTitle;
import com.renata.mycoursework.service.JobTitleService;
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
@RestController @RequestMapping("/jobTitle")
public class JobTitleController {
    private final JobTitleService jobTitleService;
    public JobTitleController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }
    @Operation(
            summary = "Отобразить все возможные должности, в какие периоды их занимали и какие сотрудники",
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
    public ResponseEntity<List<JobTitle>> findAll() {
        return new ResponseEntity<>(jobTitleService.findAll(), HttpStatus.OK);
    }
    @Operation(
            summary = "Найти по должности все периоды, когда должность занималась и кем",
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
    public ResponseEntity<Optional<JobTitle>> findById(@Parameter(name = "id", example = "1", required = true) @PathVariable Long id) {
        return new ResponseEntity<>(jobTitleService.findById(id), HttpStatus.OK);
    }
    @Operation(
            summary = "Создать новую должность",
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
    public ResponseEntity<JobTitle> create(@Parameter(hidden = true) @Valid @ModelAttribute JobTitleCreateRequest jobTitleCreateRequest) {
        return new ResponseEntity<>(jobTitleService.create(jobTitleCreateRequest), HttpStatus.CREATED);
    }
    @Operation(
            summary = "Изменить информацию о должности",
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
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Изменение информации о должности в базе данных",
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
    public ResponseEntity<JobTitle> update(@Parameter(hidden = true) @Valid @ModelAttribute JobTitleUpdateRequest jobTitleUpdateRequest) {
        return new ResponseEntity<>(jobTitleService.update(jobTitleUpdateRequest), HttpStatus.OK);
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
    public ResponseEntity<JobTitle> delete(@Parameter(name = "id", example = "1", required = true) @PathVariable Long id) {
        jobTitleService.delete(id); return new ResponseEntity<>(HttpStatus.OK);
    }
}
