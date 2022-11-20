package nextstep.subway.application;

import nextstep.subway.domain.line.Line;
import nextstep.subway.domain.line.LineRepository;
import nextstep.subway.domain.station.StationRepository;
import nextstep.subway.dto.request.LineRequest;
import nextstep.subway.dto.response.LineReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class LineService {
    private LineRepository lineRepository;
    private StationRepository stationRepository;

    @Autowired
    public LineService(LineRepository lineRepository, StationRepository stationRepository) {
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
    }

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    @Transactional
    public LineReponse createLine(LineRequest lineRequest) {
        Line line = lineRepository.save(lineRequestToLine(lineRequest));
        return LineReponse.of(line);
    }

    public List<LineReponse> getLines() {
        List<Line> lines = lineRepository.findAll();
        return lines.stream()
                .map(line -> LineReponse.of(line))
                .collect(Collectors.toList());
    }

    public LineReponse getLine(Long id) {
        Line line = lineRepository.getById(id);
        return LineReponse.of(line);
    }

    @Transactional
    public LineReponse updateLine(Long id, LineRequest lineRequest) {
        Line line = lineRepository.getById(id);
        line.updateLine(lineRequest);
        return LineReponse.of(lineRepository.save(line));
    }

    @Transactional
    public void deleteLine(Long id) {
        lineRepository.deleteById(id);
    }

    private Line lineRequestToLine(LineRequest lineRequest) {
        return new Line(
                lineRequest.getName(),
                lineRequest.getColor(),
                stationRepository.getById(lineRequest.getUpStationId()),
                stationRepository.getById(lineRequest.getDownStationId()),
                lineRequest.getDistance()
        );
    }
}
