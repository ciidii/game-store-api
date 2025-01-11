package com.ciidii.store.game;

import com.ciidii.store.common.PageResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameService {
    private GameRepository gameRepository;

    public void something() {
    }

    public PageResponse<Game> somethingElse(final int page, final int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
        Page<Game> all = gameRepository.findAll(pageable);
        return PageResponse.<Game>builder().
                content(all.getContent())
                .totalPages(all.getTotalPages())
                .totalElements(all.getNumberOfElements())
                .isFirst(all.isFirst())
                .isLast(all.isLast())
                .build();
    }
}
