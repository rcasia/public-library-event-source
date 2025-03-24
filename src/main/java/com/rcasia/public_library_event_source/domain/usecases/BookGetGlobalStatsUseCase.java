package com.rcasia.public_library_event_source.domain.usecases;

import com.rcasia.public_library_event_source.domain.projections.BookStats;

public interface BookGetGlobalStatsUseCase {
    BookStats getGlobalStats();
}
