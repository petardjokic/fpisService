package fon.is.fpis.domain.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import fon.is.fpis.domain.WorkerPosition;

@Converter(autoApply = true)
public class WorkerPositionConverter implements AttributeConverter<WorkerPosition, String>{

	@Override
	public String convertToDatabaseColumn(WorkerPosition attribute) {
		return attribute.getPosition();
	}

	@Override
	public WorkerPosition convertToEntityAttribute(String dbData) {
		return WorkerPosition.findWorkerPostion(dbData);
	}

}
