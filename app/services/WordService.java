package services;

import com.google.inject.ImplementedBy;
import models.Word;

import java.util.Set;

@ImplementedBy(ScrambleWordService.class)
public interface WordService {
    public Word getData(Integer id);
}
