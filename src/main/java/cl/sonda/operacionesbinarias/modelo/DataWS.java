package cl.sonda.operacionesbinarias.modelo;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataWS {

	@NotNull
	@JsonProperty("registryNumber")
	private Integer registryNumber;

	@JsonProperty("registryNumberOut")
	private Integer registryNumberOut;

	@JsonProperty("bytes")
	private String bytesString;
	
	public Integer getRegistryNumber() {
		return registryNumber;
	}

	public void setRegistryNumber(Integer registryNumber) {
		this.registryNumber = registryNumber;
	}

	public Integer getRegistryNumberOut() {
		return registryNumberOut;
	}

	public void setRegistryNumberOut(Integer registryNumberOut) {
		this.registryNumberOut = registryNumberOut;
	}

	public String getBytesString() {
		return bytesString;
	}

	public void setBytesString(String bytesString) {
		this.bytesString = bytesString;
	}

}
