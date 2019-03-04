r.report map=landcov unit=k
r.statistics
r.statistics base=landcov@PERMANENT cover=topo@PERMANENT method=average output=avheight
r.report map=landcov,avheight units=c -i
r.report map=landcov,avheight units=c -i
r.report
r.report map=landcov@PERMANENT
r.reclass
r.reclass input=landcov@PERMANENT output=arablind rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\7768.0
r.reclass
r.reclass input=landcov@PERMANENT output=arablind1 rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\7768.1
r.reclass input=landcov@PERMANENT output=arablind1 rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\7768.1
r.report map=landcov unit=k
r.statistics
r.statistics base=landcov@PERMANENT cover=topo@PERMANENT method=average output=avheight
r.statistics base=landcov@PERMANENT cover=topo@PERMANENT method=average output=avheight
r.report avheight
r.statistics base=landcov@PERMANENT cover=topo@PERMANENT method=average output=avheight
r.statistics base=landcov@PERMANENT cover=topo@PERMANENT method=average output=avheight1
r.report map=landcov,avheight units=c -i
r.reclass
r.reclass input=landcov@PERMANENT output=arablind rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\8340.0
r.reclass input=landcov@PERMANENT output=arablind rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\8340.0
r.reclass input=landcov@PERMANENT output=arablind rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\8340.0
r.reclass input=landcov@PERMANENT output=arablind1 rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\8340.0
r.reclass input=landcov@PERMANENT output=arablind1 rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\8340.0
r.report map =arablind, avheight units=c -i ]
r.report map =arablind, avheight units=c -i
r.report map =arablind, avheight
r.report map =arablind
r.report
r.report map=arablind@PERMANENT
r.reclass input=lancov@PERMANENT output=arablind rules=rule1
r.reclass
r.mapcalc
r.mapcalc expression=polrivers = arablind@PERMANENT * water@PERMANENT
r.report polrivers units=c
r.mapcalc polrivers = arablind@PERMANENT * water@PERMANENT
r.mapcalc polrivers1 = arablind@PERMANENT * water@PERMANENT
r.mapcalc polrivers1 = arablind@PERMANENT * water@PERMANENT
r.mapcalc polrivers1 = arablind@PERMANENT * water@PERMANENT
r.report polrivers1 units=c
r.report polrivers1 units=c
r.report polrivers1 units=c
r.report polrivers1 units=c
r.buffer rail distances=1000 output=raulbuftemp
r.buffer
r.report
r.report map=polrivers1@PERMANENT,arablind@PERMANENT
r.report
r.report map=arablind@PERMANENT
r.report
r.report map=landcov@PERMANENT
r.report map=landcov@PERMANENT
r.report map=roads@PERMANENT
r.reclass
r.reclass input=roads@PERMANENT output=mway rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\8340.2
r.buffer mway distances=1000 output=mwaybuftemp
r.reclass
r.reclass input=mwaybuftemp@PERMANENT output=waybuf rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\8340.3
r.reclass
r.report raulbuftemp
r.reclass input=raulbuftemp@PERMANENT output=railbuff rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\8340.4
r.mapcalc
r.mapcalc expression=buffers = if(isnull(mwaybuf),0,(mwaybuf)+if(isnull(railbuf),0,railbuf)
r.mapcalc expression=buffers = if(isnull(waybuf),0,(waybuf)+if(isnull(railbuf),0,railbuf)
r.mapcalc expression=buffers = if(isnull(waybuf),0,(waybuf)+if(isnull(railbuff),0,railbuff)
r.mapcalc expression=buffers = if(isnull(waybuf),0,(waybuf)+if(isnull(railbuff),0,railbuff)
r.mapcalc
r.mapcalc expression=buffers = if(isnull(waybuf),0,waybuf)+if(isnull(railbuff),0,railbuff)
r.mapcalc expression=atrisk=buffers*popln
r.report atrisk units=c
d.legend
r.report atrisk units=c
r.buffer crash distances=1000 output=crashbuf
r.mask raster=crashbuf
r.report popln units=c
g.remove type=raster name=MASK]
g.remove type=raster name=MASK
g.remove type=raster name=MASK
r.mask raster=crashbuf
r.report popln units=c
g.remove type=raster name=MASK
g.remove type=raster name=MASK -f
g.remove type=raster name=MASK
g.remove type=raster name=MASK -f
g.remove type=raster name=MASK
g.remove type=raster name=MASK
r.report atrisk
r.report atrisk units=c
d.legend
r.report popln units=c
g.remove type=raster name=MASK
g.remove type=raster name=MASK
r.report popln units=c
g.remove type=raster name=MASK
g.remove type=raster name=MASK
g.remove type=raster name=MASK
g.remove type=raster name=MASK
0
0
g.remove type=raster name=MASK
r.report popln units=c
g.remove type=raster name=MASK
g.remove type=raster name=MASK
r.report popln units=c
g.remove type=raster name=MASK
r.mask -r
-r
r.mask -r
r.report popln units=c
r.mask raster=crashbuf@PERMANENT
r.report popln units=c
g.remove type=raster name=MASK
g.remove type=raster name=crashbuf
r.report popln units=c
g.remove type=raster name=crashbuf
g.remove type=raster name=crashbuf
g.remove type=raster name=crashbuf -f
g.remove type=raster name=MASK -f
r.report popln units=c
v.in.ascii input=H:\gisdata\rainfall.txt output=rainloc z=3
v.to.rast
v.to.rast input=rainloc@PERMANENT output=rainloc use=z
r.grow input=rainloc output=rainarea radius=4
v.surf.idw input=rainloc output=raingrid1 layer=0 npoints=1
v.surf.idw input=rainloc output=raingrid2 layer=0 npoints=12
v.surf.rst input=rainloc elev=raingrid smooth=1 tension=100 layer=0
r.colors map=raingrid3 color=rainbow
r.colors map=raingrid3 color=rainbow
r.colors map=raingrid2 color=rainbow
v.surf.rst input=rainloc elev=raingrid3 smooth=1 tension=100 layer=0
r.reclass
r.reclass input=raingrid3@PERMANENT output=droughtmap rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\10156.1
r.mapcalc
r.mapcalc expression=maxheightformway = mway@PERMANENT * avheight@PERMANENT
r.report maxheightformway units=c
d.legend
g.region
g.region n=316000  s=310000  e=450000  w=444000 
g.region n=316000  s=310000  e=450000  w=444000 
r.colors image color=grey
r.slope.aspect elevation=topo aspect=asp1
r.colors asp1 color=aspect
r.colors --help
r.colors asp1 color=rainbow
r.colors asp1 color=aspect
r.reclass
r.reclass input=asp1@PERMANENT output=aspcost rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\10156.0
r.reclass
r.reclass input=landcov@PERMANENT output=landcost rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\10156.2
r.mapcalc cost = landcost + aspcost
r.mapcalc cost = landcost + aspcost
r.mapcalc cost = landcost + aspcost
r.mapcalc
r.mapcalc expression=cost = aspcost@PERMANENT + landcost@PERMANENT
r.report cost
r.colors -e map=cost@PERMANENT
r.colors -e map=cost@PERMANENT
r.colors -e map=cost@PERMANENT color=aspect
r.cost
r.cost input=cost output=costdist1 start_coordinates=445775,310875
r.drain -a input=costdist1 output=pipeline start_coordinates=444525,313875
r.reclass
r.reclass input=pipeline@PERMANENT output=pipeline2 rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\10156.3
r.patch pipeline2,landcov output=pipefinal
r.colors map=pipefinal@PERMANENT color=differences
r.colors map=pipefinal@PERMANENT color=blues
g.region n=322000 s=316000 w=444000 e=449750
g.region n=322000 s=316000 w=444000 e=449750#
g.region n=322000 s=316000 w=444000 e=449750
r.buffer urban distances=500 output=urbanbuftemp
r.reclass
r.report urbanbuftemp
r.reclass input=urbanbuftemp@PERMANENT output=urbanbuf2 rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\6704.1
r.colors map=landcov@PERMANENT color=grey
r.reclass
r.reclass input=roads@PERMANENT output=mainroads rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\6704.2
r.buffer mainroads distances=450 output=mainroadbuf
r.slope.aspect elevation=topo slope=slope1
r.reclass slope1
r.reclass slope1
r.reclass slope1
r.reclass s
r.reclass
r.reclass input=slope1@PERMANENT output=flat rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\6704.3
r.report slope1
r.reclass
r.reclass
r.report landcov
r.reclass input=landcov@PERMANENT output=grade3 rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\6704.4
r.mapcalc
r.mapcalc expression=sites = if(isnull(urbanbuf2),0,1) * if(isnull(mainroadbuf2),0,1) * flat * grade3
r.mapcalc expression=sites = if(isnull(urbanbuf2),0,1) * if(isnull(mainroadbuf),0,1) * flat * grade3
r.mapcalc expression=sites = if(isnull(urbanbuf2),0,1) * if(isnull(mainroadbuf),0,1) * flat * grade3
r.mapcalc expression=sites = if(isnull(urbanbuf2),0,1) * if(isnull(mainroadbuf),0,1) * flat * grade3
r.mapcalc
r.mapcalc expression=sites = if(isnull(urbanbuf2),0,1) * if(isnull(mainroadbuf),0,1) * flat * grad3
r.mapcalc expression=sites = if(isnull(urbanbuf2),0,1) * if(isnull(mainroadbuf),0,1) * flat * grad3
r.mapcalc expression=sites = if(isnull(urbanbuf2),0,1) * if(isnull(mainroadbuf),0,1) * flat * grad3
r.mapcalc expression=sites = if(isnull(urbanbuf2),0,1) * if(isnull(mainroadbuf),0,1) * flat * grade3
d.legend
r.report sites
r.colors map=landcov@PERMANENT color=aspect
r.colors map=landcov@PERMANENT color=grey1.0
r.colors map=landcov@PERMANENT color=random
r.colors map=landcov@PERMANENT color=blues
r.colors map=landcov@PERMANENT color=population
r.reclass
r.reclass input=sites@PERMANENT output=sites2 rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\6704.5
r.colors map=landcov@PERMANENT color=haxby
r.colors map=landcov@PERMANENT color=grey
r.clump sites output=sites2
r.clump sites output=sites3
r.report sites3 units=h
r.reclass
r.reclass input=sites3@PERMANENT output=potentialsite1 rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\6704.6
r.reclass
r.reclass input=sites3@PERMANENT output=potentialsite2 rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\6704.7
r.reclass
r.reclass input=sites3@PERMANENT output=potentialsite3 rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\6704.8
r.reclass
r.reclass input=sites3@PERMANENT output=sites4 rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\6704.9
r.report sites4
r.clump sites3 units=h
r.clump sites3 units=h
r.clump sites units=h
r.clump sites output=sites2
r.clump sites output=sites2 --overwrite
r.report sitr
r.report sites2 units=h
r.reclass
r.reclass input=sites2@PERMANENT output=sites5 rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\6704.10
r.reclass input=sites2@PERMANENT output=sites5 rules=H:\gisdata\leics\PERMANENT\.tmp/unknown\6704.10
r.to.vect input=sites5 type=area output=vectsites -s
v.report map=vertices option=coor
v.report map=vectsites option=coor
r.viewshed
r.viewshed input=topo output=MASK coordinate=444675,321875 observer_eleveation=10 max_distance=1000
r.viewshed
r.viewshed input=topo@PERMANENT output=MASK coordinates=444723.605578,321760.956175 observer_elevation=10 max_distance=1000
r.report popln units=c
g.remove -f type=raster name=MASK
r.in.ascii
r.in.ascii input=C:\Users\trand3\Downloads\toad.grd output=toads
r.in.ascii input=C:\Users\trand3\Downloads\orchid.grd output=orchid
r.in.ascii input=C:\Users\trand3\Downloads\otter.grd output=otters
r.in.ascii input=C:\Users\trand3\Downloads\wind_speed(1) output=windSpeed
r.in.ascii input=C:\Users\trand3\Downloads\soils.grd output=soil
r.in.ascii input=C:\Users\trand3\Downloads\skylark.grd output=skylark
r.in.ascii
r.in.ascii input=C:\Users\trand3\Downloads\newroad.grd output=newRoads
r.import input=\\nas-home-02\home\Documents\survey.txt output=survey
r.import input=\\nas-home-02\home\Documents\wastesites(1).txt output=wastesites_1_
v.in.ascii input=\\nas-home-02\home\Documents\rainfall.txt output=rainFall
v.in.ascii input=\\nas-home-02\home\Documents\wastesites(1).txt output=wasteSites
v.in.ascii input=\\nas-home-02\home\Documents\wastesites(1).txt output=wasteSites
v.in.ascii input=\\nas-home-02\home\Documents\wastesites(1).txt output=wasteSites
v.in.ascii input=\\nas-home-02\home\Documents\wastesites(1).txt output=wasteSites
v.in.ascii input=\\nas-home-02\home\Documents\wastesites(1).txt output=wasteSites
v.in.ascii input=\\nas-home-02\home\Documents\wastesites(1).txt output=wasteSites
v.in.ascii input=C:\Users\trand3\Downloads\wind_speed(1) output=wind_speeds
r.in.ascii
r.in.ascii input=C:\Users\trand3\Downloads\max_gust(1) output=max_gust
r.in.ascii input=C:\Users\trand3\Downloads\max_gust(1) output=max_gust
v.in.ascii input=C:\Users\trand3\Downloads\days_fog(1) output=daysFog
v.in.ascii input=\\nas-home-02\home\Documents\days_fog.txt output=daysFog
v.in.ascii input=\\nas-home-02\home\Documents\days_fog.txt output=daysFog
v.in.ascii input=\\nas-home-02\home\Documents\days_fog.txt output=daysFog
v.in.ascii input=\\nas-home-02\home\Documents\days_fog.txt output=daysFog
v.in.ascii input=\\nas-home-02\home\Documents\days_fog.txt output=daysFog
r.out.ascii
r.in.ascii
r.in.ascii input=C:\Users\trand3\Downloads\sunshine.txt output=sunshine
v.in.ascii input=C:\Users\trand3\Downloads\sunshine.txt output=sunshine
v.in.ascii input=C:\Users\trand3\Downloads\sunshine.txt output=sunshine
v.in.ascii input=C:\Users\trand3\Downloads\sunshine.txt output=sunshine
r.in.ascii
r.in.ascii input=\\nas-home-02\home\Documents\wastesites(1).txt output=cWasteSites
v.in.ascii input=\\nas-home-02\home\Documents\days_fog.txt output=hj
v.in.ascii input=\\nas-home-02\home\Documents\survey.txt output=hj
v.colors map=hj@PERMANENT use=cat color=aspectcolr
v.colors map=hj@PERMANENT use=cat color=celsius
v.in.ascii input=\\nas-home-02\home\Documents\wastesites%281%29.txt output=wasteSites
v.in.ascii input=\\nas-home-02\home\Documents\wastesites%281%29.txt output=wasteSites
v.in.ascii input=\\nas-home-02\home\Documents\wastesites%281%29.txt output=wasteSites
v.in.ascii input=\\nas-home-02\home\Documents\wastesites%281%29.txt output=wasteSites
v.in.ascii input=\\nas-home-02\home\Documents\wastesites%281%29.txt output=wasteSites
r.in.ascii input=\\nas-home-02\home\Documents\t_abs_min(1) output=min
r.in.ascii input=\\nas-home-02\home\Documents\t_abs_min(1) output=min
r.out.ascii
r.out.ascii input=orchid@PERMANENT
r.in.ascii
r.in.ascii input=C:\Users\trand3\Downloads\max_gust(1) (4) output=max_gust
r.in.ascii
r.in.ascii input=C:\Users\trand3\Downloads\t_abs_min(1) (1).txt output=vyil
r.in.xyz input=C:\Users\trand3\Downloads\t_abs_min(1) (1).txt output=minTemp
r.in.xyz input=C:\Users\trand3\Downloads\t_abs_min(1) (1).txt output=minTemp
r.in.xyz input=C:\Users\trand3\Downloads\t_abs_min(1) (1).txt output=minTemp
r.in.xyz input=C:\Users\trand3\Downloads\t_abs_min(1) (1).txt output=minTemp
v.in.ascii input=C:\Users\trand3\Downloads\t_abs_min(1) (1).txt output=hj
v.in.ascii input=C:\Users\trand3\Downloads\t_abs_min(1) (1).txt output=hj
v.in.ascii input=C:\Users\trand3\Downloads\t_abs_min(1) (1).txt output=hj
v.in.ascii input=C:\Users\trand3\Downloads\t_abs_min(1) (1).txt output=hj
v.in.ascii input=C:\Users\trand3\Downloads\t_abs_min(1) (1).txt output=hj
v.in.ascii input=C:\Users\trand3\Downloads\t_abs_min(1) (1).txt output=hj
v.in.ascii input=C:\Users\trand3\Downloads\t_abs_min(1) (1).txt output=hj
v.in.ascii input=C:\Users\trand3\Downloads\t_abs_min(1) (1).txt output=hj
v.in.ascii input=C:\Users\trand3\Downloads\t_abs_min(1) (1).txt output=bvg
r.in.ascii input=C:\Users\trand3\Downloads\t_abs_min(1) (1).txt output=vyil
r.in.ascii
r.in.ascii
r.in.ascii input=H:\gisdata\days_fog(1) output=daysFog
r.colors map=topo@PERMANENT color=aspect
r.colors map=topo@PERMANENT color=grey
r.report topo units=c
r.report landcov units=c
v.in.ascii input=C:\Users\Damon\Desktop\days_fog(1) output=days_fog
v.in.ascii input=F:\gisdata\days_fog(1) output=fog_data
v.in.ascii input=F:\gisdata\max_gust(1) output=max_gust
v.in.ascii input=F:\gisdata\sunshine(1) output=sunshine
v.in.ascii input=F:\gisdata\t_abs_max(1) output=min
v.in.ascii input=F:\gisdata\t_annual_max(1) output=annual_max
v.in.ascii input=F:\gisdata\wastesites%281%29.txt output=waste_sites
v.in.ascii input=F:\gisdata\wind_speed(1) output=wind_speed
r.buffer urban distances=300 output=urbanBuffer
g.region
g.region -d
g.region -d
r.buffer urban distances=300 output=urbanBuffer -f
r.buffer urban distances=300 output=urbanBuffer
r.buffer urban distances=300 output=urbanBuffer --overwrite
r.buffer popln distances =3000 output =popBuffer
r.buffer popln distances =3000 output=popBuffer
r.buffer popln distances=3000 output=popBuffer
r.report popln
r.report popln units=c
r.report popBuffer units=c
r.buffer popln distances=1000 output=popBuffer --overwrite
r.buffer popln distances=500 output=popBuffer --overwrite
r.report landcov
r.buffer water distances=3000 output=waterBuffer
r.buffer water distances=1000 output=waterBuffer --overwrite
r.mapcalc
r.mapcalc expression=AllBuffers = if(isnull(urbanBuffer@PERMANENT),0, urbanBuffer@PERMANENT)+if(isnull( waterBuffer@PERMANENT),0,waterBuffer@PERMANENT)+if(isnull( popBuffer@PERMANENT),0,popBuffer@PERMANENT)
r.buffer roads distances=250 output=roadBuffer
r.buffer popln distances=6000 output=popBuffer --overwrite
r.buffer popln distances=500 output=popBuffer --overwrite
r.buffer water distances=2500 output=waterBuffer --overwrite
r.buffer water distances=1000 output=waterBuffer --overwrite
r.buffer urban distances=1000 output=urbanBuffer --overwrite
r.report landcov
r.report soil units=c
d.legend
r.report
r.report map=landcov
r.report map=landcost units=c
d.legend landcost
r.buffer road distances=250 output=roadBuffer --overwrite
r.buffer roads distances=250 output=roadBuffer --overwrite
r.buffer roads distances=150 output=roadBuffer --overwrite
r.reclass
r.reclass input=otters output=ottersNB rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\14884.0
r.reclass
r.reclass input=skylark@PERMANENT output=skylarkNB rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\14884.1
r.reclass
r.reclass input=orchid@PERMANENT output=orchidNB rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\14884.2
mapcalc
r.mapcalc
r.mapcalc
r.mapcalc expression=orchidNB2 = if(isnull(orchidNB@PERMANENT),1,0)
r.reclass
r.reclass input=toads@PERMANENT output=toadsNB rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\14884.3
r.report waterBuffer
r.report otters
r.buffer otters distances=2000 output=ottersNB2
r.report ottersNB2
r.buffer otters distances=200 output=ottersNB2
r.buffer otters distances=200 output=ottersNB2 --overwrite
r.buffer otters distances=20 output=ottersNB2 --overwrite
r.buffer otters distances=20 output=ottersNB2
r.buffer otters distances=20 output=ottersNB2 --overwrite
r.buffer otters distances=20 output=ottersNB2 --overwrite
mapcalc
r.mapcalc
r.mapcalc expression=ottersNB3 = otters@PERMANENT  1=0 0=1
r.mapcalc expression=ottersNB3 = r.mapcalc "inverse = if(isnull(otters@PERMANENT ), 1, null())
r.mapcalc expression=ottersNB3 = r.mapcalc "inverse = if(isnull(otters@PERMANENT ), 1, null())
r.mapcalc expression=ottersNB3 = inverse = if(isnull(otters@PERMANENT ), 1, null())
v.buffer input=otters output=otters_buffer type=area distance=-50
r.buffer input=otters output=otters_buffer type=area distance=-50
r.buffer input=otters output=otters_buffer type=area distance=-50
r.mapcalc
r.reclass
r.reclass input=waterBuffer@PERMANENT output=waterbUfferNB23 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\14884.4
r.report otters
r.buffer otters distances=200 output=test1
r.report test1 units=c
r.mapcalc
r.reclass
r.reclass input=test1@PERMANENT output=test1NB rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\14884.5
r.report otters unitc-c]
r.report otters unitc=c
r.report otters units=c
r.reclass
r.reclass input=otters@PERMANENT output=otters2 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\14884.7
r.reclass input=otters@PERMANENT output=otters2 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\14884.7
r.reclass input=otters@PERMANENT output=otters3 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\14884.7
r.reclass input=otters@PERMANENT output=otters3 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\14884.7
r.reclass input=otters@PERMANENT output=otters4 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\14884.7
r.reclass input=otters@PERMANENT output=otters4 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\14884.7
r.reclass input=otters@PERMANENT output=otters5 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\14884.7
d.legend otters
r.reclass input=otters@PERMANENT output=otters5 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\14884.7
r.reclass input=otters@PERMANENT output=otters6 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\14884.7
r.mapcalc
r.mapcalc expression=waterBufferNB24 = if(isnull(waterBuffer@PERMANENT), -1.0*A,A)
r.mapcalc expression=waterBufferNB24 = if(isnull(waterBuffer@PERMANENT), -1.0*1,0)
r.mapcalc expression=waterBufferNB24 = if(isnull(waterBuffer@PERMANENT), -1.0*1,0)
r.mapcalc expression=waterBufferNB24 = if(isnull(waterBuffer@PERMANENT), -1.0*1,0 )
r.mapcalc expression=waterBufferNB24 = if(isnull(waterBuffer@PERMANENT), -5.0*1,0)
r.mapcalc expression=waterBufferNB24 = if(isnull(waterBuffer@PERMANENT), -5.0*1,0 )
r.mapcalc expression=waterBufferNB24 = if(isnull(waterBuffer@PERMANENT), -5.0*1,0 )
r.mapcalc expression=waterBufferNB25 = if(isnull(waterBuffer@PERMANENT), -5.0*1,0 )
r.mapcalc expression=ottersNB = if(isnull(ottersBuffer@PERMANENT), -5.0*1,0 )
r.mapcalc expression=ottersNB = if(isnull(ottersBuffer@PERMANENT), -5.0*1,0 )
r.mapcalc expression=ottersNB = if(isnull(otters@PERMANENT), -5.0*1,0 )
r.mapcalc expression=ottersNB2 = if(isnull(otters@PERMANENT), -5.0*1,0 )
r.mapcalc expression=ottersNB3 = if(isnull(otters@PERMANENT), -5.0*1,0 )
r.mapcalc expression=ottersNB4 = if(isnull(otters@PERMANENT), -5.0*1,0 )
r.mapcalc expression=ottersNB4 = if(isnull(otters@PERMANENT), -5.0*1,0 )
r.mapcalc expression=ottersNB5 = if(isnull(ottersBuffer@PERMANENT), -5.0*1,0 )
r.buffer waterBufferNB24 distances=-500 output=waterBufferNBtest1
r.buffer waterBufferNB24 distances=-5 output=waterBufferNBtest1
r.grow.shrink in=waterBuffer out=waterBufferNBtest1.shrunken radius=-2.01
r.report topo
r.grow in=ottersNB out=ottersNB.grown
r.mapcalc $MAP.shrunken = if(isnull(ottersNB.grown), ottersNB, null())
r.mapcalc $MAP.shrunken = if(isnull(ottersNB.grown), ottersNB, null())
r.mapcalc $MAP.shrunken = if(isnull(ottersNB.grown), ottersNB, null())
r.mapcalc $MAP.shrunken = if(isnull(ottersNB.grown), ottersNB, null())
g.remove inverse,inverse.grown
g.remove inverse,ottersNB.grown
r.mapcalc ottersNB.shrunken = if(isnull(ottersNB.grown), ottersNB, null())
r.colors ottersNB.shrunken rast=ottersNB
g.remove inverse,ottersNB.grown
r.mapcalc ottersNB.shrunken = if(isnull(ottersNB.grown), ottersNB, null())
r.mapcalc ottersNB.shrunken = if(isnull(ottersNB.grown), ottersNB, null()) --overwrite
r.mapcalc ottersNB.shrunken = if(isnull(ottersNB.grown), ottersNB, null()) --overwrite
r.mapcalc ottersNB.shrunken = if(isnull(ottersNB.grown), ottersNB, null())
r.mapcalc ottersNB2.shrunken = if(isnull(ottersNB.grown), ottersNB, null())
r.mapcalc ottersNB2.shrunken = if(isnull(ottersNB.grown), ottersNB, null())
r.mapcalc ottersNB2.shrunken = if(isnull(ottersNB.grown), ottersNB, null())
r.colors ottersNB2.shrunken rast=ottersNB
g.remove inverse, ottersNB2.grown
g.remove inverse, ottersNB2.grown
g.remove inverse, ottersNB2.grown
r.mapcalc
r.mapcalc expression=wuBuffer = if(isnull(waterBuffer),0,waterBuffer)+if(isnull(urbanBuffer),0,urbanBuffer)
v.in.ascii input=F:\gisdata\days_fog(1) output=day_fogs skip=1
v.in.ascii input=F:\gisdata\days_fog(1) output=day_fogs skip=2
r.report days_fog
v.surf.idw input=days_fog output=foggrid1 layer=0 npoints=1
v.surf.idw input=days_fogs output=foggrid1 layer=0 npoints=1
v.surf.idw input=day_fogs output=foggrid1 layer=0 npoints=1
v.surf.idw input=day_fogs output=foggrid1 layer=0 npoints=1
v.surf.idw input=day_fogs output=foggrid1 layer=0 npoints=1
v.to.rast input=day_fogs output=day_fogs use=z
v.to.rast input=day_fogs output=day_fogs use=
v.to.rast input=day_fogs output=day_fogs use=val
r.grow input=day_fogs output=fogArea radius=4
r.grow input=day_fogs output=fogArea radius=2
r.grow input=day_fogs output=fogArea radius=2 --overwrite
v.surf.idw input=day_fogs output=foggrid1 layer=0 npoints=1
v.surf.idw input=day_fogs output=foggrid1 layer=0 npoints=1
v.surf.idw
v.surf.idw input=day_fogs@PERMANENT output=d
v.surf.idw input=day_fogs output=foggrid1 layer=0 npoints=12
v.surf.rst input=day_fogs elev=foggrid1 smooth=1 tension=100 layer=0
v.surf.idw input=rainloc output=raingrid2 layer=0 npoints=12
v.surf.idw input=day_fogs output=foggrid2 layer=0 npoints=12
r.info map=day_fogs@PERMANENT
r.info map=rainloc@PERMANENT
v.to.rast input=day_fogs output=day_fogs use=z
v.to.rast input=day_fogs output=day_fogs use=z --overwrite
v.to.rast input=day_fogs output=day_fogs use=
v.to.rast input=day_fogs output=day_fogs use=x
v.to.rast input=day_fogs output=day_fogs use=cat
v.to.rast input=day_fogs output=day_fogs use=cat --overwrite
v.surf.idw input=day_fogs output=foggrid2 layer=0 npoints=12
v.to.rast input=day_fogs output=day_fogs use=val --overwrite
v.surf.idw input=day_fogs output=foggrid2 layer=0 npoints=12
g.region vect=444325,320325
g.region vector=day_fogs
v.surf.idw input=day_fogs output=foggrid2 layer=0 npoints=12
v.surf.idw input=day_fogs output=foggrid1 layer=0 npoints=1
v.to.rast
v.in.ascii input=F:\gisdata\rainfall.txt output=rainlocCW z=3
v.to.rast input=rainlocCW output=rainlocCW use=z
r.grow input=rainloc output=rainarea radius=4
r.grow input=rainlocCW output=rainareaCW radius=4
r.grow input=rainlocCW output=rainareaCW radius=50 --overwrite
r.grow input=rainlocCW output=rainareaCW radius=10 --overwrite
g. region -d
g.region -d
r.grow input=rainlocCW output=rainareaCW radius=4 --overwrite
v.surf.idw input=rainloc output=raingrid1 layer=0 npoints=1
v.surf.idw input=rainloc output=raingrid1 layer=0 npoints=1 --overwrite
v.surf.idw input=rainloc output=raingrid1 layer=0 npoints=12 --overwrite
v.surf.idw input=rainlocCW output=raingrid1 layer=0 npoints=12 --overwrite
v.surf.idw input=rainlocCW output=raingrid1 layer=0 npoints=1 --overwrite
v.surf.rst input=rainlocCW elev=raingrid smooth=1 tension=100 layer=0
v.surf.rst input=rainlocCW elev=raingrid smooth=1 tension=100 layer=0 --overwrite
v.surf.rst input=rainlocCW elev=raingrid smooth=1 tension=100 layer=0 --overwrite
r.report raingrid units=c
d.legend raingrid
r.colors map=raingrid color=rainbow
r.reclass
r.reclass input=raingrid@PERMANENT output=LightRain rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\16844.3
d.legend soil
r.reclass
r.reclass input=soil@PERMANENT output=soilArea rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\16844.4
r.reclass
r.reclass
r.reclass input=soil@PERMANENT output=soilArea1 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\16844.5
r.colors map=soilArea1@PERMANENT color=terrain
r.patch soilArea1,wuBuffer output=testLayer1
v.in.ascii input=F:\gisdata\wastesites%281%29.txt output=existWaste z=3
v.in.ascii input=F:\gisdata\wastesites%281%29.txt output=existWaste skip=1 z=3
v.in.ascii input=F:\gisdata\wastesites%281%29.txt output=existWaste skip=2 z=3
v.in.ascii input=F:\gisdata\wastesites%281%29.txt output=existWaste
v.in.ascii input=F:\gisdata\wastesites%281%29.txt output=existWaste skip=1
v.in.ascii input=F:\gisdata\wastesites%281%29.txt output=existWaste skip=2
v.in.ascii input=F:\gisdata\wastesites%281%29.txt output=existWaste skip=3
v.in.ascii input=F:\gisdata\wastesites%281%29.txt output=existWaste separator=comma
v.to.rast input=existWaste output=wasteSites use=val
r.grow input=wasteSites output=wasteArea radius=4
r.colors map=wasteArea@PERMANENT color=water
r.colors map=wasteArea@PERMANENT color=random
r.colors map=wasteArea@PERMANENT color=reds
r.report landcov
r.reclass
r.reclass input=toads@PERMANENT output=toadsRE1 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\16844.8
r.reclass
r.reclass input=toads@PERMANENT output=toadsRE2 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\16844.9
r.report toadsRE2
r.reclass
r.reclass input=toads output=toadsRE3 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\16844.10
r.mapcalc
r.mapcalc expression=toadsB = if(isnull(toads@PERMANENT),0,1)
r.buffer wasteArea distances=1000 output=wasteSitesBuftemp
r.reclass
v.in.ascii input=F:\gisdata\sunshine(1) output=sunshine skip=2 z=3
v.to.rast
v.to.rast input=sunshine output=sunshine use=z
v.surf.rst input=rainloc elev=raingrid smooth=1 tension=100 layer=0
v.surf.rst input=sunshine elev=raingrid smooth=1 tension=100 layer=0
r.grow input=sunshine output=sunArea radius=4
v.surf.rst input=sunshine elev=sungrid smooth=1 tension=100 layer=0
r.colors map=sungrid color=rainbow
v.in.ascii input=F:\gisdata\t_annual_max(1) output=annual_temp skip=2 z=3
v.to.rast input=annual_temp output=annual_temp use=z
r.grow input=annual_temp output=tempArea radius=4
v.surf.rst input=annual_temp elev=tempGrid smooth=1 tension=100 layer=0
r.colors map=tempGrid color=rainbow
r.reclass#
d.legend sungrid
r.reclass input=sungrid output=sunLow rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\13120.5
r.reclass
d.legend tempGrid
r.reclass input=tempGrid output=tempLow rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\13120.6
r.mapcalc sunLow * tempLow
r.mapcalc
r.mapcalc expression=LowSunTemp = sunLow@PERMANENT * tempLow@PERMANENT
r.mapcalc
r.mapcalc expression=AllBuffs = wasteSitesBuftemp@PERMANENT * urbanBuffer@PERMANENT * waterBuffer@PERMANENT
r.mapcalc wasteSitesBuftemp@PERMANENT * urbanBuffer@PERMANENT * waterBuffer@PERMANENT
r.mapcalc expression=AllBuffs1 = wasteSitesBuftemp@PERMANENT * urbanBuffer@PERMANENT * waterBuffer@PERMANENT
r.mapcalc expression=AllBuffs2 = if(isnull(wasteSitesBuftemp@PERMANENT),0,1) * if(isnull(urbanBuffer@PERMANENT),0,1) * if(isnull(waterBuffer@PERMANENT),0,1)
r.mapcalc expression=AllBuffs3 = if(isnull(wasteSitesBuftemp@PERMANENT),0,wasteSitesBuftemp) * if(isnull(urbanBuffer@PERMANENT),0,urbanBuffer) * if(isnull(waterBuffer@PERMANENT),0, waterBuffer)
r.mapcalc expression=AllBuffs4 = if(isnull(wasteSitesBuftemp@PERMANENT),0,wasteSitesBuftemp) +  if(isnull(urbanBuffer@PERMANENT),0,urbanBuffer) + if(isnull(waterBuffer@PERMANENT),0, waterBuffer)
r.mapcalc expression=AllBuffs4 = if(isnull( AllBuffs4@PERMANENT ),0,1) * soilArea1
r.mapcalc expression=AllBuffswSoil = if(isnull( AllBuffs4@PERMANENT ),0,1) * soilArea1
r.mapcalc expression=BigBoiLayer = if(isnull( AllBuffswSoil@PERMANENT ),0,1) * LowSunTemp
r.mapcalc expression=BigBoiLayer2 = if(isnull( AllBuffswSoil@PERMANENT ),0,1) + LowSunTemp
r.mapcalc expression=BigBoiLayer3 = if(isnull( AllBuffswSoil@PERMANENT ),0,1) * if(isnull(LowSunTemp),0,1)
r.mapcalc
r.mapcalc expression=AllBuffswSoil2 = if(isnull( AllBuffs4@PERMANENT ),0,1) * soilArea1@PERMANENT
r.mapcalc expression=AllBuffswSoil3 = if(isnull( AllBuffs4@PERMANENT ),0,1) +  soilArea1@PERMANENT
r.reclass
r.reclass input=soilArea1 output=soilArea2 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\15468.0
r.reclass input=soilArea1 output=soilArea3 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\15468.0
r.reclasss
r.reclass
r.reclass input=landcov output=landcost2 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\15468.1
r.colors map=landcost2@PERMANENT color=rainbow
r.colors map=landcost2@PERMANENT color=curvature
r.reclass
r.reclass input=landcov output=landcost3 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\15468.2
r.reclass
r.reclass input=soil output=soilArea3 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\15468.3
r.reclass input=soil output=soilArea4 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\15468.3
d.legend soil
r.reclass input=soil output=soilArea5 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\15468.3
r.mapcalc
r.mapcalc expression=AllBuffsWSoil2 = if(isnull( soilArea4@PERMANENT),0,1) *  if(isnull(AllBuffs4@PERMANENT),0,1)
r.mapcalc expression=AllBuffsWSoil3 = if(isnull( soilArea4@PERMANENT),0,1) *  if(isnull(AllBuffs4@PERMANENT),0,1)
r.mapcalc expression=AllBuffsWSoil4 = if(isnull( soilArea4@PERMANENT),0,1) *  if(isnull(AllBuffs4@PERMANENT),0,1)
r.mapcalc expression=AllBuffsWSoil5 = if(isnull( soilArea4@PERMANENT),0,1) +  if(isnull(AllBuffs4@PERMANENT),0,1)
r.reclass
r.reclass input=soilArea4 output=goodSoil rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\15468.4
r.reclass input=soilArea4 output=goodSoil2 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\15468.4
r.mapcalc
r.mapcalc expression=CompLayer1 = if(isnull(AllBuffs4),0,1) *  if(isnull(landcost3),0,1) * goodSoil2
r.mapcalc expression=CompLayer2 = if(isnull(AllBuffs4),0,1) *  if(isnull(landcost3),0,1) +  goodSoil2
r.mapcalc
r.mapcalc expression=SoilwCost = if(isnull( goodSoil2@PERMANENT),0,1) * if(isnull( landcost3@PERMANENT),0,1)
r.mapcalc
r.mapcalc expression=CompLayer2 = if(isnull( AllBuffs4@PERMANENT),0,1) * grade3 * landcost3
r.mapcalc expression=CompLayer3 = if(isnull( AllBuffs4@PERMANENT),0,1) * grade3 * landcost3
r.mapcalc expression=CompLayer4 = if(isnull( AllBuffs4@PERMANENT),0,1) * if(isnull(grade3)0,1) * if(isnull(landcost3),0,1)
r.mapcalc expression=CompLayer4 = if(isnull( AllBuffs4@PERMANENT),0,1) * if(isnull(grade3)0,1) *  if(isnull(landcost3),0,1)
r.mapcalc expression=CompLayer4 = if(isnull( AllBuffs4@PERMANENT),0,1) * if(isnull(grade3)0,1) *  if(isnull(landcost3),0,1)
r.mapcalc expression=CompLayer4 = if(isnull( AllBuffs4@PERMANENT),0,1) *  if(isnull(grade3)0,1) *  if(isnull(landcost3),0,1)
r.mapcalc expression=CompLayer4 = if(isnull( AllBuffs4@PERMANENT),0,1) *  if(isnull(grade3)0,1) *  if(isnull(landcost3),0,1)
r.mapcalc expression=CompLayer4 = if(isnull( AllBuffs4@PERMANENT),0,1) *  if(isnull(grade3)0,1) *  if(isnull(landcost3),0,1)
r.mapcalc expression=CompLayer4 = if(isnull( AllBuffs4@PERMANENT),0,1) *  if(isnull(grade3)0,1) *  if(isnull(landcost3),0,1)
r.mapcalc expression=CompLayer4 = if(isnull( AllBuffs4@PERMANENT),0,1) *  if(isnull(goodSoil2)0,1) *  if(isnull(landcost3),0,1)
r.mapcalc expression=CompLayer4 = if(isnull( AllBuffs4@PERMANENT),0,1) *  if(isnull(goodSoil2)0,1)
r.mapcalc expression=CompLayer4 = if(isnull( AllBuffs4@PERMANENT),0,1) *  goodSoil2
r.reclass
r.report allBuffs4 units=c
d.legend allBuffs4
r.reclass input=allBuffs4 output=FinalBuffer rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\8112.0
r.colors map=FinalBuffer@PERMANENT color=byg
r.mapcalc
r.mapcalc expression=finalLayer = goodSoil2 + FinalBuffer
r.mapcalc expression=finalLayer2 = goodSoil2 * FinalBuffer
r.mapcalc expression=finalLayer3 = goodSoil2 + FinalBuffer
r.reclass
r.reclass input=finalLayer3 output=soilAndBuffer rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\8112.1
r.reclass input=finalLayer3 output=soilAndBuffer rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\8112.1
r.colors map=finalLayer3@PERMANENT color=differences
r.mapcalc expression=soilWithLowSunTemp = goodSoil2 * if(isnull( LowSunTemp),0,1)
r.colors map=goodSoil2@PERMANENT color=water
r.mapcalc expression=soilWithLowSunTemp2 = goodSoil2 * if(isnull( LowSunTemp),0,1)
r.reclass
r.reclass input=soil output=goodSoil3 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\8112.2
r.reclass input=soil output=goodSoil4 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\8112.2
r.mapcalc expression=soilWithLowSunTemp3 = if(isnull(goodSoil4),0,1) * if(isnull( LowSunTemp),0,1)
r.mapcalc expression=soilWithLowSunTemp4 = if(isnull(goodSoil4),0,1) + if(isnull( LowSunTemp),0,1)
r.mapcalc expression=soilWithLowSunTemp5 = if(isnull( goodSoil4@PERMANENT),0,goodSoil2) + if(isnull( LowSunTemp@PERMANENT),0,landcost3)
r.mapcalc expression=soilWithLowSunTemp6 = if(isnull( goodSoil4@PERMANENT),0,goodSoil2) * if(isnull( LowSunTemp@PERMANENT),0,landcost3)
r.mapcalc expression=soilWithLowSunTemp7 = if(isnull( goodSoil4@PERMANENT),0,goodSoil4) * if(isnull( LowSunTemp@PERMANENT),0, LowSunTemp)
r.mapcalc expression=soilWithLowSunTemp8 = if(isnull( goodSoil4@PERMANENT),0,1) * if(isnull( LowSunTemp@PERMANENT),0, 1
r.mapcalc expression=soilWithLowSunTemp8 = if(isnull( goodSoil4@PERMANENT),0,1) * if(isnull( LowSunTemp@PERMANENT),0, 1)
r.mapcalc
r.mapcalc expression=FinalBibBOI = if(isnull(soilWithLowSunTemp7),0,1) * FinalBuffer
r.mapcalc expression=FinalBibBOI1 = if(isnull(soilWithLowSunTemp7),0,1) + FinalBuffer
r.mapcalc expression=FinalBibBOI2 = if(isnull(soilWithLowSunTemp7),0,1) * if(isnull(FinalBuffer),0,1)
r.mapcalc expression=FinalBibBOI2 = if(isnull(soilWithLowSunTemp7),0,1) +  if(isnull(FinalBuffer),0,1)
r.mapcalc expression=FinalBibBOI2 = if(isnull(soilWithLowSunTemp7),0,1) + if(isnull(FinalBuffer),0,1) --overwrite
r.mapcalc expression=FinalBibBOI3 = if(isnull(soilWithLowSunTemp7),0,1) +  if(isnull(FinalBuffer),0,1)
r.mapcalc expression=FinalBibBOI3 = if(isnull(soilWithLowSunTemp7),0,1) *  if(isnull(AllBuffs4),0,1)
r.mapcalc expression=FinalBibBOI4 = if(isnull(soilWithLowSunTemp7),0,1) *  if(isnull(AllBuffs4),0,1)
r.mapcalc expression=FinalBibBOI5 = if(isnull(soilWithLowSunTemp7),0,1) +  if(isnull(AllBuffs4),0,1)
d.legend AllBuffs4
r.report AllBuffs4
r.reclass
r.reclass input=AllBuffs4 output=FinalBuffer2 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\8112.3
r.reclass input=AllBuffs4 output=FinalBuffer2 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\8112.3
r.reclass input=AllBuffs4 output=FinalBuffer3 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\8112.3
r.mapcalc expression=FinalBibBOI6 = if(isnull(soilWithLowSunTemp7),0,1) +  if(isnull(FinalBuffer2),0,1)
r.mapcalc expression=FinalBibBOI7 = if(isnull(soilWithLowSunTemp7),0,1) *  if(isnull(FinalBuffer2),0,1)
r.mapcalc expression=FinalBibBOI7 = if(isnull(soilWithLowSunTemp7),0,1) +  if(isnull(FinalBuffer2),0,FinalBuffer2)
r.mapcalc expression=FinalBibBOI8 = if(isnull(soilWithLowSunTemp7),0,1) +  if(isnull(FinalBuffer2),0,FinalBuffer2)
r.mapcalc expression=FinalBibBOI9 = if(isnull(soilWithLowSunTemp7),0,soilWithLowSunTemp7) +  if(isnull(FinalBuffer2),0,FinalBuffer2)
r.mapcalc
r.mapcalc expression=finalbibboi7 = if(isnull(soilWithLowSunTemp7),0,1) * if(isnull(FinallBuffer3),0,1)
r.mapcalc expression=finalbibboi7 = if(isnull(soilWithLowSunTemp7),0,1) * if(isnull(FinalBuffer3),0,1)
r.mapcalc expression=finalbibboi8 = if(isnull(soilWithLowSunTemp7),0,1) * if(isnull(FinalBuffer3),0,1)
r.mapcalc expression=finalbibboi9 = if(isnull(soilWithLowSunTemp7),0,1) * if(isnull(FinalBuffer3),0,1)
r.mapcalc expression=finalbibboi10 = if(isnull(soilWithLowSunTemp7),0,1) * if(isnull(FinalBuffer3),0,1)
r.mapcalc expression=finalbibboi11 = soilWithLowSunTemp7 *FinalBuffer3
r.clump finalbigboi11 output=finalbigboiM2
r.clump finalbibboi11 output=finalbigboiM2
r.report finalbiboi11M2 units=h
r.report finalbigoi11M2 units=h
r.report finalbigboi11M2 units=h
r.report finalbigboi1M2 units=h
r.report finalbigboiM2 units=h
d. legend finalbigboiM2
d.legend finalbigboiM2
r.mapcalc
r.mapcalc expression=GoodSoilWithgrade3AndLowSunTemp = if(isnull(goodSoil4),0,1) * if(isnull(grade3),0,1) * if(isnull(LowSunTemp),0,1)
r.mapcalc expression=FinalBufferWLowSunTempWgrade3WgoodSoil = GoodSoilWithgrade3AndLowSunTemp * if(isnull(FinalBuffer),0,1)
r.mapcalc expression=FinalBufferWLowSunTempWgrade3WgoodSoil2 = if(isnull(GoodSoilWithgrade3AndLowSunTemp),0,1) * if(isnull(FinalBuffer),0,1)
r.mapcalc expression=SoilWSunTempWgrade3 = soilWithLowSunTemp7 *FinalBuffer*grad3
r.mapcalc expression=SoilWSunTempWgrade3 = soilWithLowSunTemp7 *FinalBuffer*grade3
r.mapcalc
r.mapcalc expression=soilG3SunTemp = if(isnull(grade3),0,1) * if(isnull(goodSoil4),0,1) * if(isnull(LowSunTemp),0,1)
r.mapcalc expression=soilG3SunTemp = if(isnull(grade3),0,1) +  if(isnull(goodSoil4),0,1) +  if(isnull(LowSunTemp),0,1)
r.mapcalc expression=soilG3SunTemp2 = if(isnull(grade3),0,1) +  if(isnull(goodSoil4),0,1) +  if(isnull(LowSunTemp),0,1)
r.mapcalc expression=soilG3SunTemp3 = if(isnull(grade3),0,LowSunTemp) *  if(isnull(goodSoil4),0,LowSunTemp) *  if(isnull(LowSunTemp),0,LowSunTemp)
r.clump soilG3SunTemp3 output=LFsites
d.legend LFsites
d.legend LFsites
r.mapcalc expression=soilG3SunTemp3WBuffer = soilG3SunTemp3 * if(isnull(FinalBuffer),0,1)
r.mapcalc expression=soilG3SunTemp3WBuffer2 = if(isnull(soilG3SunTemp3),0,soilG3SunTemp3) * if(isnull(FinalBuffer),0,1)
r.mapcalc expression=soilG3SunTemp3WBuffer3 = if(isnull(soilG3SunTemp3),0,soilG3SunTemp3) +  if(isnull(FinalBuffer),0,1)
r.mapcalc expression=soilG3SunTemp3WBuffer4 = soilG3SunTemp3 * if(isnull(FinalBuffer),0,1)
r.mapcalc expression=soilG3SunTemp3WBuffer5 = soilG3SunTemp3 * if(isnull(FinalBuffer),0,FinalBuffer)
r.mapcalc expression=soilG3SunTemp3WBuffer5 = soilG3SunTemp3 * FinalBuffer3
r.mapcalc expression=soilG3SunTemp3WBuffer6 = soilG3SunTemp3 * FinalBuffer3
r.clump soilG3SunTemp3WBuffer6 output=LFsites2
d.legend LFsites2
r.report LFsites2 units=h
r.reclass
r.reclass input=LFsites2 output=potentialSites rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\7448.0
r.category
r.category map=potentialSites@PERMANENT
r.category map=potentialSites@PERMANENT raster=potentialSites@PERMANENT format=$1 Site$?s
r.report potentialSites
r.reclass
r.reclass input=potentialSites output=potentialSites rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\7448.1
r.reclass input=potentialSites output=potentialSites2 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\7448.1
r.report potentialSites2
r.report potentialSites
r.reclass input=potentialSites output=potentialSites3 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\7448.1
r.report potentialSites3
r.reclass
r.report landcov
r.reclass input=landcov output=gradeIII rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\7448.2
r.reclass input=landcov output=landcost4 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\7448.3
r.reclass input=landcov output=landcost5 rules=F:\gisdata\leics\PERMANENT\.tmp/unknown\7448.3
r.report landcost4
r.mapcalc
r.mapcalc expression=landCostGrade3Soil = if(isnull(landCost5),0,landCost5) * if(isnull(grade3),0,grade3) * if(isnull(goodSoil4),0,goodSoil4)
r.mapcalc expression=landCostGrade3Soil2 = if(isnull(landCost5),0,landCost5) * if(isnull(grade3),0,grade3) * if(isnull(goodSoil4),0,1)
r.mapcalc expression=landCostGrade3Soil2 = if(isnull(landCost5),0,landCost5) * if(isnull(grade3),0,grade3) * goodSoil
r.mapcalc expression=landCostGrade3Soil3 = if(isnull(landCost5),0,landCost5) * if(isnull(grade3),0,grade3) * goodSoil
r.report landcov
d.legend potentialSites3
r.reclass
r.colors map=soilArea3@PERMANENT color=grass
r.colors map=soilArea3@PERMANENT color=greens
