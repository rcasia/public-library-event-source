package com.rcasia.public_library_event_source.domain.ports;

import com.rcasia.public_library_event_source.domain.projections.BookStats;

public interface BookStatsGetGlobalStatsPort {
    BookStats getGlobalStats();
}
