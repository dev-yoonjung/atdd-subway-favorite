package nextstep.subway.path.utils;

import lombok.Builder;
import nextstep.global.error.code.ErrorCode;
import nextstep.global.error.exception.InvalidPathException;
import nextstep.subway.path.vo.Path;
import nextstep.subway.section.entity.Section;
import nextstep.subway.station.entity.Station;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;
import java.util.Optional;

public class ShortestPathHelper {

    private final WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    private final Station source;

    private final Station target;

    @Builder
    public ShortestPathHelper(
            List<Station> stations,
            List<Section> sections,
            Station source,
            Station target
    ) {
        setVertexes(stations);
        setEdges(sections);
        this.source = source;
        this.target = target;
    }

    public Path getPath() {
        DijkstraShortestPath<Station, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        return Optional.ofNullable(dijkstraShortestPath.getPath(source, target))
                .map(Path::new)
                .orElseThrow(() -> new InvalidPathException(ErrorCode.UNLINKED_DEPARTURE_AND_ARRIVAL_STATIONS));
    }

    private void setVertexes(List<Station> stations) {
        stations.forEach(graph::addVertex);
    }

    private void setEdges(List<Section> sections) {
        sections.forEach(section -> {
            DefaultWeightedEdge edge = graph.addEdge(section.getUpStation(), section.getDownStation());
            graph.setEdgeWeight(edge, section.getDistance());
        });
    }

}
