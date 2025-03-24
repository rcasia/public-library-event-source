package com.rcasia.public_library_event_source.appliation;

import com.rcasia.public_library_event_source.domain.ports.BookStatsGetGlobalStatsPort;
import com.rcasia.public_library_event_source.domain.projections.BookStats;
import com.rcasia.public_library_event_source.domain.usecases.BookGetGlobalStatsUseCase;
import org.springframework.stereotype.Service;

@Service
public class BookGetGlobalStatsService implements BookGetGlobalStatsUseCase {

    private final BookStatsGetGlobalStatsPort bookStatsGetGlobalStatsPort;

    public BookGetGlobalStatsService(BookStatsGetGlobalStatsPort bookStatsGetGlobalStatsPort) {
        this.bookStatsGetGlobalStatsPort = bookStatsGetGlobalStatsPort;
    }

    @Override
    public BookStats getGlobalStats() {
        return this.bookStatsGetGlobalStatsPort.getGlobalStats();
    }
}
