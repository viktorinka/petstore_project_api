package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Builder
@AllArgsConstructor
@Jacksonized
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PetBody {
    @JsonProperty(required = true)
    private Category category;

    @JsonProperty(required = true)
    private String name;

    @JsonProperty(required = true)
    private List<String> photoUrls;

    @JsonProperty(required = true)
    private List<Tag> tags;

    @JsonProperty(required = true)
    private String status;

    @JsonProperty(required = true)
    private Long id;
}
