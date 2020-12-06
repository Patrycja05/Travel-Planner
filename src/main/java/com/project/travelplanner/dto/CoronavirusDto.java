package com.project.travelplanner.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CoronavirusDto {
    private Long newConfirmed;
    private Long totalConfirmed;
    private Long newDeaths;
    private Long totalDeaths;
    private Long newRecovered;
    private Long totalRecovered;

    public static class CoronavirusDtoBuilder {
        private Long newConfirmed;
        private Long totalConfirmed;
        private Long newDeaths;
        private Long totalDeaths;
        private Long newRecovered;
        private Long totalRecovered;

        public CoronavirusDtoBuilder newConfirmed(Long newConfirmed) {
            this.newConfirmed = newConfirmed;
            return this;
        }

        public CoronavirusDtoBuilder totalConfirmed(Long totalConfirmed) {
            this.totalConfirmed = totalConfirmed;
            return this;
        }

        public CoronavirusDtoBuilder newDeaths(Long newDeaths) {
            this.newDeaths = newDeaths;
            return this;
        }

        public CoronavirusDtoBuilder totalDeaths(Long totalDeaths) {
            this.totalDeaths = totalDeaths;
            return this;
        }

        public CoronavirusDtoBuilder newRecovered(Long newRecovered) {
            this.newRecovered = newRecovered;
            return this;
        }

        public CoronavirusDtoBuilder totalRecovered(Long totalRecovered) {
            this.totalRecovered = totalRecovered;
            return this;
        }

        public CoronavirusDto build(){
            return new CoronavirusDto(newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered, totalRecovered);
        }
    }

    public CoronavirusDto(Long newConfirmed, Long totalConfirmed, Long newDeaths, Long totalDeaths, Long newRecovered, Long totalRecovered) {
        this.newConfirmed = newConfirmed;
        this.totalConfirmed = totalConfirmed;
        this.newDeaths = newDeaths;
        this.totalDeaths = totalDeaths;
        this.newRecovered = newRecovered;
        this.totalRecovered = totalRecovered;
    }

    public Long getNewConfirmed() {
        return newConfirmed;
    }

    public Long getTotalConfirmed() {
        return totalConfirmed;
    }

    public Long getNewDeaths() {
        return newDeaths;
    }

    public Long getTotalDeaths() {
        return totalDeaths;
    }

    public Long getNewRecovered() {
        return newRecovered;
    }

    public Long getTotalRecovered() {
        return totalRecovered;
    }

    @Override
    public String toString() {
        return "CoronavirusDto{" +
                "newConfirmed=" + newConfirmed +
                ", totalConfirmed=" + totalConfirmed +
                ", newDeaths=" + newDeaths +
                ", totalDeaths=" + totalDeaths +
                ", newRecovered=" + newRecovered +
                ", totalRecovered=" + totalRecovered +
                '}';
    }
}
