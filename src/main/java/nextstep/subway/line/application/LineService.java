package nextstep.subway.line.application;

import nextstep.subway.line.domain.Line;
import nextstep.subway.line.domain.LineRepository;
import nextstep.subway.line.dto.LineRequest;
import nextstep.subway.line.dto.LineResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LineService {
    private LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public LineResponse saveLine(LineRequest request) {
        Line persistLine = new Line();
        try {
            persistLine = lineRepository.save(request.toLine());
        } catch (Exception e) {
            System.out.println(e.getMessage()); //log.error
        } finally {
            return LineResponse.of(persistLine);
        }
    }

    public List<LineResponse> findByAll() {
        List<Line> lines = lineRepository.findAll();
        return lines.stream().map(line -> LineResponse.of(line)).collect(Collectors.toList());
    }

    public LineResponse findById(Long id) {
        Line line = new Line();
        try {
            line = lineRepository.findById(id).get();
        } catch (Exception e) {
            System.out.println(e.getMessage()); //log.error
        } finally {
            return LineResponse.of(line);
        }
    }

    public LineResponse updateLine(LineRequest lineRequest, Long id) {
        Line line = lineRepository.findById(id).get();
        line.update(lineRequest.toLine());
        return LineResponse.of(line);
    }

    public void deleteLine(Long id) {
        lineRepository.deleteById(id);
    }
}
