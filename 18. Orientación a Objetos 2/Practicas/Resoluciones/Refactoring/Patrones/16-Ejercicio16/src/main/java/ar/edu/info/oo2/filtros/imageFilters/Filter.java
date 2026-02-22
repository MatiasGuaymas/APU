package ar.edu.info.oo2.filtros.imageFilters;

import java.awt.image.BufferedImage;

public abstract class Filter {
  abstract public BufferedImage filter(BufferedImage image);
}
