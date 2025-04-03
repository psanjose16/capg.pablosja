export interface Film {
  filmId: number;
  title: string;
}

export interface FilmDetailsDTO {
  id: number;
  title: string;
  description: string;
  rating: string;
  length: number;
}

export interface FilmEditDTO {
  id: number;
  title: string;
  description: string;
  rating: string;
  length: number;
}

export interface FilmShortDTO {
  id: number;
  title: string;
}
