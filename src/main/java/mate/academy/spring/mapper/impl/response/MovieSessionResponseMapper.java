package mate.academy.spring.mapper.impl.response;

import java.time.format.DateTimeFormatter;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.response.MovieSessionResponseDto;
import mate.academy.spring.mapper.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionResponseMapper implements DtoResponseMapper<MovieSessionResponseDto,
                                                                     MovieSession> {
    private static final String DATE_PATTERN = "dd.MM.yyyy HH:mm";

    @Override
    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setId(movieSession.getId());
        movieSessionResponseDto.setMovieTitle(movieSession.getMovie().getTitle());
        movieSessionResponseDto.setShowTime(movieSession.getShowTime()
                                            .format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
        movieSessionResponseDto.setCinemaHallCapacity(movieSession.getCinemaHall().getCapacity());
        return movieSessionResponseDto;
    }
}
