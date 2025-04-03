export interface Href {
  href: string;
}

export interface CatalogLinks {
  self: Href;
  actores: Href;
  peliculas: Href;
  categorias: Href;
  idiomas: Href;
  novedades: Href;
  documentacion: Href;
}

export interface CatalogResources {
  _links: CatalogLinks;
}
