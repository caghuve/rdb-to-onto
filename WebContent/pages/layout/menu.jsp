<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<script type="text/javascript">
function goToPage(page){
	window.location.href="<html:rewrite page='/" + page + ".do' />";
}
$(document).ready(function(){
	$(".navbar-nav li").removeClass("active");
});
</script>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<!--<a class="navbar-brand" href="#" onclick="javascript: goToPage('Overview');"><bean:message key="label.overview" /></a>-->
		</div>
		<div>
			<ul class="nav navbar-nav">
				<li id="rdbtoonto-page" class="active"><a href="#" onclick="javascript: goToPage('RdbToOnto');"><bean:message key="label.rdb.to.onto" /></a></li>
				
				
				<!--<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"><bean:message key="label.project_documentation" /><span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#"><bean:message key="label.project" /></a></li>
						<li><a href="#"><bean:message key="label.documentation" /></a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"><bean:message key="label.template" /><span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#"><bean:message key="label.database.structure" /></a></li>
						<li><a href="#"><bean:message key="label.database.records" /></a></li>
					</ul>
				</li>
				<li id="script-page" class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"><bean:message key="label.scripts" /><span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#"><bean:message key="label.upper.level.ontology" /></a></li>
						<li><a href="#"><bean:message key="label.project.database" /></a></li>
						<li><a href="#" onclick="javascript: goToPage('GoCleanDataBase');"><bean:message key="label.clean.db" /></a></li>
						<li><a href="#" onclick="javascript: goToPage('GoDownloadOWLFile');"><bean:message key="label.download.owl" /></a></li>
					</ul>
				</li>
				<li><a href="#"><bean:message key="label.contact" /></a></li>-->
			</ul>
		</div>
	</div>
</nav>
