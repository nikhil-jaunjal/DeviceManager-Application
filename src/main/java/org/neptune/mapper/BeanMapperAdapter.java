package org.neptune.mapper;

import java.util.List;

public interface BeanMapperAdapter
{

	public <F, T> T map(F fromBean, Class<T> clazz, String mapId);

	public <F, T> void map(List<F> fromBeans, List<T> toBeans);

	public <F, T> void map(F fromBean, T toBean);

	public <F, T> List<T> map(List<F> beans, Class<T> clazz);

	public <F, T> T map(F fromBean, Class<T> clazz);

}
